package ru.yusdm.cloudtraining.zuul.cityservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yusdm.cloudtraining.zuul.cityservice.model.City;
import ru.yusdm.cloudtraining.zuul.cityservice.repo.CityRepo;
import ru.yusdm.cloudtraining.zuul.cityservice.service.CityService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    private CityRepo cityRepo;

    @Autowired
    public CityServiceImpl(CityRepo cityRepo) {
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
    public List<City> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        cityRepo.deleteById(id);
    }
}
