package ru.yusdm.cloudtraining.zuul.streetservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.yusdm.cloudtraining.zuul.streetservice.model.Street;
import ru.yusdm.cloudtraining.zuul.streetservice.service.StreetLocalService;

@SpringBootApplication
public class StreetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreetServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(StreetLocalService streetService) {
		return args -> {
			//russia - Moscow
			streetService.save(new Street(1L, "Red square"));
			streetService.save(new Street(1L, "Tverskaya"));
			streetService.save(new Street(1L, "Gagarina"));
			//russia - Spb
			streetService.save(new Street(2L, "Nevsky"));
			streetService.save(new Street(2L, "Prosvesheniya"));
			streetService.save(new Street(2L, "Ispytateley"));

			//belarus - Minsk
			streetService.save(new Street(3L, "Minsk street1"));
			streetService.save(new Street(3L, "Minsk street2"));
			streetService.save(new Street(3L, "Minsk street3"));
			//belarus - Vitebsk
			streetService.save(new Street(4L, "Vitebsk street1"));
			streetService.save(new Street(4L, "Vitebsk street2"));
			streetService.save(new Street(4L, "Vitebsk street3"));

			//ukraine - Kiev
			streetService.save(new Street(5L, "Kiev street1"));
			streetService.save(new Street(5L, "Kiev street2"));
			streetService.save(new Street(5L, "Kiev street3"));

			//ukraine - Odessa
			streetService.save(new Street(6L, "Odessa street1"));
			streetService.save(new Street(6L, "Odessa street2"));
		};
	}

}
