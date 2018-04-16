package ru.yusdm.zuultraining.common.dto;

import java.io.Serializable;
import java.util.List;

public class CountryDTO implements Serializable{
    private Long id;
    private String name;
    private String description;
    private List<CityDTO> cities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CityDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityDTO> cities) {
        this.cities = cities;
    }
}
