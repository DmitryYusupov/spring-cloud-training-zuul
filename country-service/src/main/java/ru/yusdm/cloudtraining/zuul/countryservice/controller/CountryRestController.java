package ru.yusdm.cloudtraining.zuul.countryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yusdm.cloudtraining.zuul.common.dto.CountryDTO;
import ru.yusdm.cloudtraining.zuul.countryservice.model.Country;
import ru.yusdm.cloudtraining.zuul.countryservice.service.CountryDistributedService;
import ru.yusdm.cloudtraining.zuul.countryservice.service.CountryLocalService;
import ru.yusdm.cloudtraining.zuul.countryservice.utils.DtoModelConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.ok;
import static ru.yusdm.cloudtraining.zuul.countryservice.utils.DtoModelConverter.dtoToModel;
import static ru.yusdm.cloudtraining.zuul.countryservice.utils.DtoModelConverter.modelToDTO;


@RestController
@RequestMapping(value = "/countries")
public class CountryRestController {

    private CountryLocalService countryService;

    private CountryDistributedService countryDistributedService;

    @Autowired
    public CountryRestController(CountryLocalService countryService,
                                 CountryDistributedService countryDistributedService) {
        this.countryService = countryService;
        this.countryDistributedService = countryDistributedService;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDTO> update(@RequestBody CountryDTO countryDTO) {
        Country country = countryService.save(dtoToModel(countryDTO));
        return new ResponseEntity<>(modelToDTO(country), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable long id) {
        countryService.deleteById(id);
        return new ResponseEntity(OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDTO> save(@RequestBody CountryDTO countryDTO) {
        Country country = countryService.save(dtoToModel(countryDTO));
        return new ResponseEntity<>(modelToDTO(country), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getById(@PathVariable long id) {
        Optional<CountryDTO> country = countryDistributedService.findById(id);
        return country.map(c -> ok().body(c)).
                orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> findAll() {
        List<CountryDTO> countries = countryService.findAll().stream()
                .map(DtoModelConverter::modelToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(countries, OK);
    }

}
