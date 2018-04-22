package ru.yusdm.cloudtraining.zuul.streetservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yusdm.cloudtraining.zuul.streetservice.model.Street;

import java.util.List;


@Repository
public interface StreetRepo extends JpaRepository<Street, Long> {
    List<Street> findAllByCityId(long cityId);
    void deleteByCityId(long cityId);
}
