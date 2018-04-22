package ru.yusdm.cloudtraining.zuul.cityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yusdm.cloudtraining.zuul.cityservice.model.City;
import ru.yusdm.cloudtraining.zuul.cityservice.service.CityDistributedService;
import ru.yusdm.cloudtraining.zuul.cityservice.service.CityLocalService;
import ru.yusdm.cloudtraining.zuul.cityservice.utils.DtoModelConverter;
import ru.yusdm.cloudtraining.zuul.common.dto.CityDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.ok;
import static ru.yusdm.cloudtraining.zuul.cityservice.utils.DtoModelConverter.dtoToModel;
import static ru.yusdm.cloudtraining.zuul.cityservice.utils.DtoModelConverter.modelToDTO;

@RestController
@RequestMapping("/cities")
public class CityRestController {

    private CityLocalService cityService;

    private CityDistributedService cityDistributedService;

    @Autowired
    public CityRestController(CityLocalService cityService,
                              CityDistributedService cityDistributedService) {
        this.cityService = cityService;
        this.cityDistributedService = cityDistributedService;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDTO> update(@RequestBody CityDTO cityDTO) {
        City city = cityService.save(dtoToModel(cityDTO));
        return new ResponseEntity<>(modelToDTO(city), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable long id) {
        cityService.deleteById(id);
        return new ResponseEntity(OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDTO> save(@RequestBody CityDTO cityDTO) {
        City city = cityService.save(dtoToModel(cityDTO));
        return new ResponseEntity<>(modelToDTO(city), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable long id) {
        Optional<CityDTO> country = cityDistributedService.findById(id);
        return country.map(c -> ok().body(c)).
                orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/query")
    public ResponseEntity<List<CityDTO>> find(@RequestParam("countryId") Long countryId) {
        if (countryId != null) {
            List<CityDTO> cities = cityService.findAllByCountryId(countryId)
                    .stream().map(DtoModelConverter::modelToDTO).collect(Collectors.toList());
            return new ResponseEntity<>(cities, OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
