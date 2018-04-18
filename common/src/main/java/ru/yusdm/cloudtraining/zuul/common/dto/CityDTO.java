package ru.yusdm.cloudtraining.zuul.common.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class CityDTO implements Serializable {
    private Long id;
    private Long countryId;
    private String name;
    private int population;
    private List<StreetDTO> streets;
}
