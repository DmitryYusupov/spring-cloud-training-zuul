package ru.yusdm.cloudtraining.zuul.countryservice.service;

import ru.yusdm.cloudtraining.zuul.common.dto.CountryDTO;

import java.util.Optional;

public interface CountryDistributedService {
    Optional<CountryDTO> findById(long id);
}
