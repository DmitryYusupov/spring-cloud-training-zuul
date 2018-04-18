package ru.yusdm.cloudtraining.zuul.streetservice.model;

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
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CITY_ID")
    private Long cityId;

    @Column(name = "NAME")
    private String name;

    public Street(Long cityId, String name) {
        this.cityId = cityId;
        this.name = name;
    }

}
