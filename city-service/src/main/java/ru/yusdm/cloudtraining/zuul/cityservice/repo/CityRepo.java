package ru.yusdm.cloudtraining.zuul.cityservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yusdm.cloudtraining.zuul.cityservice.model.City;

import java.util.List;


@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    List<City> findAllByCountryId(long countryId);
    void deleteByCountryId(long countryId);
}
