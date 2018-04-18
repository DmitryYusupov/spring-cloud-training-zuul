package ru.yusdm.cloudtraining.zuul.countryservice.utils;


import ru.yusdm.cloudtraining.zuul.common.dto.CountryDTO;
import ru.yusdm.cloudtraining.zuul.countryservice.model.Country;

public class DtoModelConverter {

    private DtoModelConverter() {

    }

    public static Country dtoToModel(CountryDTO countryDTO) {
        Country country = new Country();
        country.setId(countryDTO.getId());
        country.setName(countryDTO.getName());
        country.setDescription(countryDTO.getDescription());
        return country;
    }

    public static CountryDTO modelToDTO(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());
        countryDTO.setDescription(country.getDescription());
        return countryDTO;
    }
}
