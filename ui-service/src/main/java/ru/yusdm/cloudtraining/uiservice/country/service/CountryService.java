package ru.yusdm.cloudtraining.uiservice.country.service;

import ru.yusdm.cloudtraining.zuul.common.dto.CountryDTO;

import java.util.List;

public interface CountryService {
    List<CountryDTO> findAll();

    void deleteById(long id);

    CountryDTO save(CountryDTO countryDTO);
}
