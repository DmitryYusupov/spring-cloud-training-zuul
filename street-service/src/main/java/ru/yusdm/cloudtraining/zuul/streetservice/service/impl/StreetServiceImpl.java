package ru.yusdm.cloudtraining.zuul.streetservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yusdm.cloudtraining.zuul.streetservice.model.Street;
import ru.yusdm.cloudtraining.zuul.streetservice.repo.StreetRepo;
import ru.yusdm.cloudtraining.zuul.streetservice.service.StreetService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StreetServiceImpl implements StreetService {

    private StreetRepo streetRepo;

    @Autowired
    public StreetServiceImpl(StreetRepo streetRepo) {
        this.streetRepo = streetRepo;
    }

    @Override
    public Street save(Street street) {
        return streetRepo.save(street);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Street> findById(Long id) {
        return streetRepo.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Street> findAll() {
        return streetRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        streetRepo.deleteById(id);
    }
}
