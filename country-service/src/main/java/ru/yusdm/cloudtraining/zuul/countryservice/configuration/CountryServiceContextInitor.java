package ru.yusdm.cloudtraining.zuul.countryservice.configuration;

import org.springframework.stereotype.Component;
import ru.yusdm.cloudtraining.zuul.common.filter.ServiceContextHolder;

import javax.annotation.PostConstruct;

@Component
public class CountryServiceContextInitor {

    @PostConstruct
    public void initCityServiceContextHolder() {
        ServiceContextHolder.setSupplier(CountryServiceContext::new);
    }

}
