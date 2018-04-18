package ru.yusdm.cloudtraining.zuul.common.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class CountryDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private List<CityDTO> cities;
}
