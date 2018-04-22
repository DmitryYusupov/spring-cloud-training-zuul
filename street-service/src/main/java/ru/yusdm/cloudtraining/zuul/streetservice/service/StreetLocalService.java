package ru.yusdm.cloudtraining.zuul.streetservice.service;

import ru.yusdm.cloudtraining.zuul.streetservice.model.Street;

import java.util.List;
import java.util.Optional;

public interface StreetLocalService {
    Street save(Street street);

    Optional<Street> findById(Long id);

    List<Street> findAllByCityId(long cityId);

    void deleteById(Long id);
}
