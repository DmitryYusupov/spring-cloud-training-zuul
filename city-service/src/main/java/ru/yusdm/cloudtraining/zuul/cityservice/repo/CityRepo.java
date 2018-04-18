package ru.yusdm.cloudtraining.zuul.cityservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yusdm.cloudtraining.zuul.cityservice.model.City;


@Repository
public interface CityRepo extends JpaRepository<City, Long> {
}
