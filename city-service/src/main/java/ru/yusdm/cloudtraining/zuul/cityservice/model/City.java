package ru.yusdm.cloudtraining.zuul.cityservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COUNTRY_ID")
    private Long countryId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "POPULATION")
    private int population;

}
