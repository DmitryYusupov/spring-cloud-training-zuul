package ru.yusdm.cloudtraining.zuul.cityservice.service;

import ru.yusdm.cloudtraining.zuul.cityservice.model.City;

import java.util.List;
import java.util.Optional;

public interface CityLocalService {
    City save(City city);

    Optional<City> findById(Long id);

    List<City> findAllByCountryId(long countryId);

    void deleteById(long id);

    void deleteByCountryId(long countryId);

}
