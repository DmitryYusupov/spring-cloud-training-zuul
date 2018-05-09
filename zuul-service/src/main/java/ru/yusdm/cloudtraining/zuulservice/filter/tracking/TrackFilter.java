package ru.yusdm.cloudtraining.zuulservice.filter.tracking;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static ru.yusdm.cloudtraining.zuulservice.filter.tracking.TrackingFilterUtils.generateAndSetCorrelationId;
import static ru.yusdm.cloudtraining.zuulservice.filter.tracking.TrackingFilterUtils.getCorrelationId;
import static ru.yusdm.cloudtraining.zuulservice.filter.tracking.TrackingFilterUtils.isCorrelationIdExists;


@Component
public class TrackFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackFilter.class);
    private static final int FILTER_ORDER = 1;
    private static final String FILTER_TYPE = "pre";

    @Override
    public String filterType() {
        return FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        LOGGER.info("Filter is running!");
        RequestContext ctx = RequestContext.getCurrentContext();
        LOGGER.info("Processing request '{}'", ctx.getRequest().getRequestURI());

        if (isCorrelationIdExists()) {
            LOGGER.info("Correlation id exists. Its value is {}", getCorrelationId());
        } else {
            LOGGER.info("Correlation id not found. Try to set it");
            generateAndSetCorrelationId();
            LOGGER.info("Correlation id '{}' successfully set", getCorrelationId());
        }

        return null;
    }
}
