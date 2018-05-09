package ru.yusdm.cloudtraining.zuul.common.filter;

import java.util.function.Supplier;

public class ServiceContextHolder {

    private static final ThreadLocal<ServiceContext> serviceContext = new ThreadLocal<>();

    private static Supplier<ServiceContext> supplier;

    public static ServiceContext getContext() {
        ServiceContext context = serviceContext.get();

        if (context == null) {
            serviceContext.set(createContext());
        }

        return serviceContext.get();
    }

    public static void setContext(ServiceContext context) {
        serviceContext.set(context);
    }

    private static ServiceContext createContext() {
        return supplier.get();
    }

    public static void setSupplier(Supplier<ServiceContext> supplier) {
        ServiceContextHolder.supplier = supplier;
    }
}
