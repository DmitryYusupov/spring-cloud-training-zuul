package ru.yusdm.cloudtraining.zuul.countryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import ru.yusdm.cloudtraining.zuul.countryservice.model.Country;
import ru.yusdm.cloudtraining.zuul.countryservice.service.CountryLocalService;

@EnableFeignClients
@SpringBootApplication
public class CountryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CountryLocalService countryService) {
        return args -> {
            countryService.save(new Country("Russia", "Best country"));
            countryService.save(new Country("Belarus", "Good country"));
            countryService.save(new Country("Ukraine", "Nice country"));
        };
    }
}
