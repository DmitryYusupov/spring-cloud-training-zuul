package ru.yusdm.cloudtraining.zuul.cityservice.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import ru.yusdm.cloudtraining.zuul.cityservice.configuration.CityServiceContext;
import ru.yusdm.cloudtraining.zuul.cityservice.configuration.FilterConstants;
import ru.yusdm.cloudtraining.zuul.common.filter.ServiceContextHolder;

import java.io.IOException;

@Component
public class CityHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityHttpRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        LOGGER.info("Interceptor in action");
        String correlationId = ((CityServiceContext) ServiceContextHolder.getContext()).getCorrelationId();
        LOGGER.info("Propagate header with correlation id '{}'", correlationId);


        HttpHeaders headers = request.getHeaders();
        headers.add(FilterConstants.HEADER_CORRELATION_ID, correlationId);

        LOGGER.info("Exec request '{}'", request.getURI());
        return execution.execute(request, body);
    }

}
