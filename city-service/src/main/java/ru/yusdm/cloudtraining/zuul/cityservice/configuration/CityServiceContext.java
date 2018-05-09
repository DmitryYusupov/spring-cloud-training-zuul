package ru.yusdm.cloudtraining.zuul.cityservice.configuration;

import ru.yusdm.cloudtraining.zuul.common.filter.ServiceContext;

public class CityServiceContext extends ServiceContext {
    private String correlationId;

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
