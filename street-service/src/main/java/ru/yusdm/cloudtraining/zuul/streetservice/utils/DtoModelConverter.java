package ru.yusdm.cloudtraining.zuul.streetservice.utils;


import ru.yusdm.cloudtraining.zuul.common.dto.StreetDTO;
import ru.yusdm.cloudtraining.zuul.streetservice.model.Street;

public class DtoModelConverter {

    private DtoModelConverter() {

    }

    public static Street dtoToModel(StreetDTO streetDTO) {
        Street street = new Street();
        street.setId(streetDTO.getId());
        street.setName(streetDTO.getName());
        street.setCityId(streetDTO.getCityId());
        return street;
    }

    public static StreetDTO modelToDTO(Street street) {
        StreetDTO streetDTO = new StreetDTO();
        streetDTO.setId(street.getId());
        streetDTO.setName(street.getName());
        streetDTO.setCityId(street.getCityId());
        return streetDTO;
    }

}
