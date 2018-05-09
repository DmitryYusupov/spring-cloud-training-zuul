package ru.yusdm.cloudtraining.zuul.countryservice.configuration;

import ru.yusdm.cloudtraining.zuul.common.filter.ServiceContext;

public class CountryServiceContext extends ServiceContext {
    private String correlationId;

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
