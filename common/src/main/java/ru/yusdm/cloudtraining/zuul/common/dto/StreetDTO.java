package ru.yusdm.cloudtraining.zuul.common.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class StreetDTO implements Serializable{
    private Long id;
    private Long cityId;
    private String name;
}
