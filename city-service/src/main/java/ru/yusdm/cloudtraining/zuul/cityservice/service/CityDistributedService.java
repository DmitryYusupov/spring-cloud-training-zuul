package ru.yusdm.cloudtraining.zuul.cityservice.service;


import org.springframework.http.ResponseEntity;
import ru.yusdm.cloudtraining.zuul.common.dto.CityDTO;

import java.util.List;
import java.util.Optional;

public interface CityDistributedService {
    Optional<CityDTO> findById(long id);
    List<CityDTO> findAllByCountryId(long countryId);
    ResponseEntity deleteByCountryId(long countryId);
}
