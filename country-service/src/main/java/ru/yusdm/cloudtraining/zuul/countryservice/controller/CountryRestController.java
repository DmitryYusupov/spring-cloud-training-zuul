package ru.yusdm.cloudtraining.zuul.countryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yusdm.cloudtraining.zuul.common.dto.CountryDTO;
import ru.yusdm.cloudtraining.zuul.countryservice.model.Country;
import ru.yusdm.cloudtraining.zuul.countryservice.service.CountryService;
import ru.yusdm.cloudtraining.zuul.countryservice.utils.DtoModelConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.yusdm.cloudtraining.zuul.countryservice.utils.DtoModelConverter.dtoToModel;
import static ru.yusdm.cloudtraining.zuul.countryservice.utils.DtoModelConverter.modelToDTO;


@RestController
@RequestMapping(value = "countries")
public class CountryRestController {

    private CountryService countryService;

    @Autowired
    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDTO> update(@RequestBody CountryDTO countryDTO) {
        Country country = countryService.save(dtoToModel(countryDTO));
        return new ResponseEntity<>(modelToDTO(country), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        countryService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDTO> save(@RequestBody CountryDTO countryDTO) {
        Country country = countryService.save(dtoToModel(countryDTO));
        return new ResponseEntity<>(modelToDTO(country), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CountryDTO> getById(@PathVariable Long id) {
        Country country = countryService.findById(id).orElse(null);
        return Optional.ofNullable(country).map(c -> ResponseEntity.ok().body(modelToDTO(c))).
                orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public ResponseEntity<List<CountryDTO>> findAll() {
        List<CountryDTO> countries = countryService.findAll().stream().map(DtoModelConverter::modelToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

}
