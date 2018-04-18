package ru.yusdm.cloudtraining.zuul.streetservice.service;

import ru.yusdm.cloudtraining.zuul.streetservice.model.Street;

import java.util.List;
import java.util.Optional;

public interface StreetService {
    Street save(Street street);

    Optional<Street> findById(Long id);

    List<Street> findAll();

    void deleteById(Long id);
}
