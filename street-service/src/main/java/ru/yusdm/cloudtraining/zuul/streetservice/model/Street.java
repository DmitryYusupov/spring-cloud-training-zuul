package ru.yusdm.cloudtraining.zuul.streetservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
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
