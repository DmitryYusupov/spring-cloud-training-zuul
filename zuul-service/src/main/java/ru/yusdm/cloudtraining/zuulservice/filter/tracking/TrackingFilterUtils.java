package ru.yusdm.cloudtraining.zuulservice.filter.tracking;

import com.netflix.zuul.context.RequestContext;

import java.util.UUID;

class TrackingFilterUtils {

    private static final String HEADER_CORRELATION_ID = "correlation_id";

    private TrackingFilterUtils() {
    }

    static String getCorrelationId() {
        RequestContext ctx = RequestContext.getCurrentContext();

        String correlationId = ctx.getRequest().getHeader(HEADER_CORRELATION_ID);

        if (correlationId != null) {
            return correlationId;
        } else {
            return ctx.getZuulRequestHeaders().get(HEADER_CORRELATION_ID);
        }
    }

    static void generateAndSetCorrelationId() {
        String correlationId = generateCorrelationId();
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(HEADER_CORRELATION_ID, correlationId);
    }

    static boolean isCorrelationIdExists() {
        return getCorrelationId() != null;
    }

    private static String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

}
