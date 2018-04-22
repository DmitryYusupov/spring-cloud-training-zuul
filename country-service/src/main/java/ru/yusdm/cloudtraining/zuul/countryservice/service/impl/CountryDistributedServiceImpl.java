package ru.yusdm.cloudtraining.zuul.countryservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yusdm.cloudtraining.zuul.common.dto.CityDTO;
import ru.yusdm.cloudtraining.zuul.common.dto.CountryDTO;
import ru.yusdm.cloudtraining.zuul.countryservice.feign.CityFeignClient;
import ru.yusdm.cloudtraining.zuul.countryservice.model.Country;
import ru.yusdm.cloudtraining.zuul.countryservice.service.CountryDistributedService;
import ru.yusdm.cloudtraining.zuul.countryservice.service.CountryLocalService;

import java.util.List;
import java.util.Optional;

import static ru.yusdm.cloudtraining.zuul.common.distributed.ResponseEntityUtils.extractEntityIfOkOrThrewError;
import static ru.yusdm.cloudtraining.zuul.countryservice.utils.DtoModelConverter.modelToDTO;

@Service
public class CountryDistributedServiceImpl implements CountryDistributedService {

    private CountryLocalService countryLocalService;

    private CityFeignClient cityFeignClient;

    @Autowired
    public CountryDistributedServiceImpl(CountryLocalService countryLocalService, CityFeignClient cityFeignClient) {
        this.countryLocalService = countryLocalService;
        this.cityFeignClient = cityFeignClient;
    }

    @Override
    public Optional<CountryDTO> findById(long id) {
        Country country = countryLocalService.findById(id).orElse(null);
        CountryDTO countryDTO = null;
        if (country != null) {
            countryDTO = modelToDTO(country);
            List<CityDTO> cities = extractEntityIfOkOrThrewError(cityFeignClient.findByCountryId(id));
            countryDTO.setCities(cities);
        }
        return Optional.ofNullable(countryDTO);
    }
}
