package ru.yusdm.cloudtraining.zuul.streetservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yusdm.cloudtraining.zuul.streetservice.model.Street;


@Repository
public interface StreetRepo extends JpaRepository<Street, Long> {
}
