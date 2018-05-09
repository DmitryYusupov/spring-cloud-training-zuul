package ru.yusdm.cloudtraining.zuul.streetservice.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.yusdm.cloudtraining.zuul.common.filter.ServiceContextHolder;
import ru.yusdm.cloudtraining.zuul.streetservice.configuration.StreetServiceContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static ru.yusdm.cloudtraining.zuul.streetservice.configuration.FilterConstants.HEADER_CORRELATION_ID;

@Component
public class StreetServiceFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreetServiceFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Street service filter in action!");
        LOGGER.info("Retrieving correlation id from request header");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String correlationId = httpServletRequest.getHeader(HEADER_CORRELATION_ID);
        LOGGER.info("Correlation id is '{}'", correlationId);

        LOGGER.info("Set correlation id to service context");
        StreetServiceContext context = (StreetServiceContext) ServiceContextHolder.getContext();
        context.setCorrelationId(correlationId);

        LOGGER.info("Context contains correlation id '{}'", context.getCorrelationId());
        chain.doFilter(httpServletRequest, response);
    }

    @Override
    public void destroy() {

    }
}
