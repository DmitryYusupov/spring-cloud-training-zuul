package ru.yusdm.cloudtraining.zuul.countryservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.yusdm.cloudtraining.zuul.common.dto.CityDTO;

import java.util.List;

@Service
@FeignClient(name = "cities", url = "http://localhost:8082/cities")
public interface CityFeignClient {

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CityDTO> update(@RequestBody CityDTO cityDTO);

    @DeleteMapping("/{id}")
    ResponseEntity deleteById(@PathVariable("id") long id);

    @GetMapping("/deletebycountryid")
    ResponseEntity deleteByCountryId(@RequestParam("country_id")long countryId);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CityDTO> save(@RequestBody CityDTO cityDTO);

    @GetMapping("{id}")
    ResponseEntity<CityDTO> getById(@PathVariable("id") long id);

    @GetMapping("/query")
    ResponseEntity<List<CityDTO>> findByCountryId(@RequestParam("country_id") long countryId);

}
