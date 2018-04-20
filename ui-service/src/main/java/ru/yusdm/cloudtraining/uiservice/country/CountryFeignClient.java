package ru.yusdm.cloudtraining.uiservice.country;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.yusdm.cloudtraining.zuul.common.dto.CountryDTO;

import java.util.List;

@Service
@FeignClient(name = "countries" , url = "http://localhost:8081/countries")
//@FeignClient(name = "countries")
public interface CountryFeignClient {
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CountryDTO> update(@RequestBody CountryDTO countryDTO);

    @DeleteMapping("/{id}")
    ResponseEntity deleteById(@PathVariable("id") Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CountryDTO> save(@RequestBody CountryDTO countryDTO);

    //@GetMapping("{id}")
    //ResponseEntity<CountryDTO> getById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<CountryDTO>> findAll();
}
