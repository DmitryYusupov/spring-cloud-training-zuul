package ru.yusdm.cloudtraining.zuul.cityservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.yusdm.cloudtraining.zuul.cityservice.feign.StreetFeignClient;
import ru.yusdm.cloudtraining.zuul.cityservice.model.City;
import ru.yusdm.cloudtraining.zuul.cityservice.service.CityDistributedService;
import ru.yusdm.cloudtraining.zuul.cityservice.service.CityLocalService;
import ru.yusdm.cloudtraining.zuul.cityservice.utils.DtoModelConverter;
import ru.yusdm.cloudtraining.zuul.common.dto.CityDTO;
import ru.yusdm.cloudtraining.zuul.common.dto.StreetDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;
import static ru.yusdm.cloudtraining.zuul.cityservice.utils.DtoModelConverter.modelToDTO;

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
            cityDTO.setStreets(getStreetsByCityId(id));
        }
        return Optional.ofNullable(cityDTO);
    }

    private List<StreetDTO> getStreetsByCityId(long cityId) {
        return streetFeignClient.findByCityId(cityId).getBody();
    }

    @Override
    public List<CityDTO> findAllByCountryId(long countryId) {
        List<CityDTO> cities = cityLocalService.findAllByCountryId(countryId)
                .stream().map(DtoModelConverter::modelToDTO).collect(Collectors.toList());
        cities.forEach(city -> {
            city.setStreets(getStreetsByCityId(city.getId()));
        });
        return cities;
    }

    @Override
    public ResponseEntity deleteByCountryId(long countryId) {
        List<Long> citiesIdsToDelete = getCitiesIdsToDelete(countryId);
        //remove cities locally
        cityLocalService.deleteByCountryId(countryId);
        //remove all streets which belongs to cities
        citiesIdsToDelete.forEach(cityId -> {
            streetFeignClient.deleteByCityId(cityId);
        });
        return new ResponseEntity(OK);
    }

    private List<Long> getCitiesIdsToDelete(long countryId) {
        return cityLocalService.findAllByCountryId(countryId)
                .stream().map(City::getId).collect(Collectors.toList());
    }
}
