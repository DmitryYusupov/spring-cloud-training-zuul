package ru.yusdm.cloudtraining.uiservice.country.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.yusdm.cloudtraining.uiservice.country.CountryFeignClient;
import ru.yusdm.cloudtraining.uiservice.country.service.CountryService;
import ru.yusdm.cloudtraining.uiservice.utils.ResponseEntityUtils;
import ru.yusdm.cloudtraining.zuul.common.dto.CountryDTO;

import java.util.List;

import static ru.yusdm.cloudtraining.uiservice.utils.ResponseEntityUtils.extractFromResponseEntity;
import static ru.yusdm.cloudtraining.uiservice.utils.ResponseEntityUtils.threwErrorIfResponseStatusIsNotOK;


@Service
public class CountryServiceImpl implements CountryService {

    private CountryFeignClient countryFeignClient;

    @Autowired
    public CountryServiceImpl(CountryFeignClient countryFeignClient) {
        this.countryFeignClient = countryFeignClient;
    }

    @Override
    public List<CountryDTO> findAll() {
        return extractFromResponseEntity(countryFeignClient.findAll());
    }

    @Override
    public void deleteById(long id) {
        ResponseEntity response = countryFeignClient.deleteById(id);
        threwErrorIfResponseStatusIsNotOK(response.getStatusCode());
    }

    @Override
    public CountryDTO update(CountryDTO country) {
        return null;
    }

    @Override
    public CountryDTO save(CountryDTO countryDTO) {
        return null;
    }
}
