package ru.yusdm.cloudtraining.zuul.cityservice.service;


import ru.yusdm.cloudtraining.zuul.common.dto.CityDTO;

import java.util.Optional;

public interface CityDistributedService {
    Optional<CityDTO> findById(long id);
}
