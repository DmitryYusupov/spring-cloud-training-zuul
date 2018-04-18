package ru.yusdm.cloudtraining.zuul.cityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yusdm.cloudtraining.zuul.cityservice.model.City;
import ru.yusdm.cloudtraining.zuul.cityservice.service.CityService;
import ru.yusdm.cloudtraining.zuul.cityservice.utils.DtoModelConverter;
import ru.yusdm.cloudtraining.zuul.common.dto.CityDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.yusdm.cloudtraining.zuul.cityservice.utils.DtoModelConverter.dtoToModel;
import static ru.yusdm.cloudtraining.zuul.cityservice.utils.DtoModelConverter.modelToDTO;

@RestController
@RequestMapping("/cities")
public class CityRestController {

    private CityService cityService;

    @Autowired
    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDTO> update(@RequestBody CityDTO cityDTO) {
        City city = cityService.save(dtoToModel(cityDTO));
        return new ResponseEntity<>(modelToDTO(city), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        cityService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDTO> save(@RequestBody CityDTO cityDTO) {
        City city = cityService.save(dtoToModel(cityDTO));
        return new ResponseEntity<>(modelToDTO(city), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable Long id) {
        City city = cityService.findById(id).orElse(null);
        return Optional.ofNullable(city).map(c -> ResponseEntity.ok().body(modelToDTO(c))).
                orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public ResponseEntity<List<CityDTO>> findAll() {
        List<CityDTO> cities = cityService.findAll().stream().map(DtoModelConverter::modelToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

}
