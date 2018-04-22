package ru.yusdm.cloudtraining.uiservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.yusdm.cloudtraining.uiservice.feign.CountryFeignClient;
import ru.yusdm.cloudtraining.uiservice.service.ApplicationService;
import ru.yusdm.cloudtraining.zuul.common.dto.CountryDTO;

import java.util.List;


@Service
public class ApplicationServiceImpl implements ApplicationService {

    private CountryFeignClient countryFeignClient;

    @Autowired
    public ApplicationServiceImpl(CountryFeignClient countryFeignClient) {
        this.countryFeignClient = countryFeignClient;
    }

    @Override
    public List<CountryDTO> findAll() {
        return countryFeignClient.findAll().getBody();
    }

    @Override
    public void deleteById(long id) {
        countryFeignClient.deleteById(id);
    }

    @Override
    public ResponseEntity<CountryDTO> getById(long countryId) {
        return countryFeignClient.getById(countryId);
    }
}
