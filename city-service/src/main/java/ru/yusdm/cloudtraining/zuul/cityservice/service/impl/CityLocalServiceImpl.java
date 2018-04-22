package ru.yusdm.cloudtraining.zuul.cityservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yusdm.cloudtraining.zuul.cityservice.model.City;
import ru.yusdm.cloudtraining.zuul.cityservice.repo.CityRepo;
import ru.yusdm.cloudtraining.zuul.cityservice.service.CityLocalService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityLocalServiceImpl implements CityLocalService {

    private CityRepo cityRepo;

    @Autowired
    public CityLocalServiceImpl(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    @Override
    public City save(City city) {
        return cityRepo.save(city);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<City> findById(Long id) {
        return cityRepo.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<City> findAllByCountryId(long countryId) {
        return cityRepo.findAllByCountryId(countryId);
    }

    @Override
    public void deleteById(Long id) {
        cityRepo.deleteById(id);
    }
}
