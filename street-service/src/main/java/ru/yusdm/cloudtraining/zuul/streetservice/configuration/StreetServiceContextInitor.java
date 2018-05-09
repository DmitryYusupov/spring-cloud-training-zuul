package ru.yusdm.cloudtraining.zuul.streetservice.configuration;

import org.springframework.stereotype.Component;
import ru.yusdm.cloudtraining.zuul.common.filter.ServiceContextHolder;

import javax.annotation.PostConstruct;

@Component
public class StreetServiceContextInitor {

    @PostConstruct
    public void initCityServiceContextHolder() {
        ServiceContextHolder.setSupplier(StreetServiceContext::new);
    }

}
