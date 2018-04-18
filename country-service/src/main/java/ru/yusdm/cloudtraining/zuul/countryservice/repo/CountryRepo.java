package ru.yusdm.cloudtraining.zuul.countryservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yusdm.cloudtraining.zuul.countryservice.model.Country;


@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
}
