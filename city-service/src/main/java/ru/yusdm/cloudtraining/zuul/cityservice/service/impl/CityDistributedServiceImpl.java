package ru.yusdm.cloudtraining.zuul.cityservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yusdm.cloudtraining.zuul.cityservice.feign.StreetFeignClient;
import ru.yusdm.cloudtraining.zuul.cityservice.model.City;
import ru.yusdm.cloudtraining.zuul.cityservice.service.CityDistributedService;
import ru.yusdm.cloudtraining.zuul.cityservice.service.CityLocalService;
import ru.yusdm.cloudtraining.zuul.common.dto.CityDTO;
import ru.yusdm.cloudtraining.zuul.common.dto.StreetDTO;

import java.util.List;
import java.util.Optional;

import static ru.yusdm.cloudtraining.zuul.cityservice.utils.DtoModelConverter.modelToDTO;
import static ru.yusdm.cloudtraining.zuul.common.distributed.ResponseEntityUtils.extractEntityIfOkOrThrewError;

@Service
public class CityDistributedServiceImpl implements CityDistributedService {

    private StreetFeignClient streetFeignClient;

    private CityLocalService cityLocalService;

    @Autowired
    public CityDistributedServiceImpl(StreetFeignClient streetFeignClient,
                                      CityLocalService cityLocalService) {
        this.streetFeignClient = streetFeignClient;
        this.cityLocalService = cityLocalService;
    }

    @Override
    public Optional<CityDTO> findById(long id) {
        City city = cityLocalService.findById(id).orElse(null);
        CityDTO cityDTO = null;
        if (city != null) {
            cityDTO = modelToDTO(city);
            List<StreetDTO> streets = extractEntityIfOkOrThrewError(streetFeignClient.findByCityId(id));
            cityDTO.setStreets(streets);
        }
        return Optional.ofNullable(cityDTO);
    }

}
