package ru.yusdm.cloudtraining.zuul.cityservice.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.yusdm.cloudtraining.zuul.common.dto.StreetDTO;

import java.util.List;

@Service
@FeignClient(name = "streets" , url = "http://localhost:8083/streets")
public interface StreetFeignClient {
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<StreetDTO> update(@RequestBody StreetDTO streetDTO);

    @DeleteMapping("/{id}")
    ResponseEntity deleteById(@PathVariable("id") Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<StreetDTO> save(@RequestBody StreetDTO streetDTO);

    @GetMapping("{id}")
    ResponseEntity<StreetDTO> getById(@PathVariable("id") Long id);

    @GetMapping("/query")
    ResponseEntity<List<StreetDTO>> findByCityId(@RequestParam("cityId") Long countryId);

}
