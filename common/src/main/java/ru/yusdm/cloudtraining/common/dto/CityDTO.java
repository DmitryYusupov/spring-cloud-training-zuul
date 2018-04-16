package ru.yusdm.cloudtraining.common.dto;

import java.io.Serializable;
import java.util.List;

public class CityDTO implements Serializable {
    private Long id;
    private Long countryId;
    private String name;
    private int population;
    private List<StreetDTO> streets;

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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<StreetDTO> getStreets() {
        return streets;
    }

    public void setStreets(List<StreetDTO> streets) {
        this.streets = streets;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
