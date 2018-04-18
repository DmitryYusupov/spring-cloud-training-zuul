package ru.yusdm.cloudtraining.zuul.cityservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.yusdm.cloudtraining.zuul.cityservice.model.City;
import ru.yusdm.cloudtraining.zuul.cityservice.service.CityService;

@SpringBootApplication
public class CityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CityService cityService) {
        return args -> {
            //russia
            cityService.save(City.builder().countryId(1L).name("Moscow").population(1500).build());
            cityService.save(City.builder().countryId(1L).name("Spb").population(1400).build());
            //belarus
            cityService.save(City.builder().countryId(2L).name("Minsk").population(1300).build());
            cityService.save(City.builder().countryId(2L).name("Vitebsk").population(1200).build());
            //ukraine
            cityService.save(City.builder().countryId(3L).name("Kiev").population(1300).build());
            cityService.save(City.builder().countryId(3L).name("Novograd-Volynskiy").population(1200).build());
        };
    }

}
