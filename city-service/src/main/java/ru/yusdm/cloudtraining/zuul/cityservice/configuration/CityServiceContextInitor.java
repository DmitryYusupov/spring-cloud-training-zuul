package ru.yusdm.cloudtraining.zuul.cityservice.configuration;

import org.springframework.stereotype.Component;
import ru.yusdm.cloudtraining.zuul.common.filter.ServiceContextHolder;

import javax.annotation.PostConstruct;

@Component
public class CityServiceContextInitor {

    @PostConstruct
    public void initCityServiceContextHolder() {
        ServiceContextHolder.setSupplier(CityServiceContext::new);
    }

}
