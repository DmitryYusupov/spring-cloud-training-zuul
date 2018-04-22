package ru.yusdm.cloudtraining.zuul.countryservice.service;

import ru.yusdm.cloudtraining.zuul.countryservice.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryLocalService {

    Country save(Country country);

    Optional<Country> findById(Long id);

    List<Country> findAll();

    void deleteById(Long id);
}
