package ru.yusdm.cloudtraining.zuul.countryservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yusdm.cloudtraining.zuul.countryservice.model.Country;
import ru.yusdm.cloudtraining.zuul.countryservice.repo.CountryRepo;
import ru.yusdm.cloudtraining.zuul.countryservice.service.CountryService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private CountryRepo countryRepo;

    @Autowired
    public CountryServiceImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public Country save(Country country) {
        return countryRepo.save(country);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Country> findById(Long id) {
        return countryRepo.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Country> findAll() {
        return countryRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        countryRepo.deleteById(id);
    }
}
