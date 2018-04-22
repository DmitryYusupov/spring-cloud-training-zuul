package ru.yusdm.cloudtraining.uiservice.service;

import org.springframework.http.ResponseEntity;
import ru.yusdm.cloudtraining.zuul.common.dto.CountryDTO;

import java.util.List;

public interface ApplicationService {

    List<CountryDTO> findAll();

    void deleteById(long id);

    ResponseEntity<CountryDTO> getById(long countryId);
}
