package ru.yusdm.cloudtraining.zuul.cityservice.utils;


import ru.yusdm.cloudtraining.zuul.cityservice.model.City;
import ru.yusdm.cloudtraining.zuul.common.dto.CityDTO;

public class DtoModelConverter {
    private DtoModelConverter() {

    }

    public static City dtoToModel(CityDTO cityDTO) {
        City country = new City();
        country.setId(cityDTO.getId());
        country.setName(cityDTO.getName());
        country.setPopulation(cityDTO.getPopulation());
        country.setCountryId(cityDTO.getCountryId());
        return country;
    }

    public static CityDTO modelToDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setPopulation(city.getPopulation());
        cityDTO.setCountryId(city.getCountryId());
        return cityDTO;
    }

}
