package ru.yusdm.cloudtraining.zuul.streetservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yusdm.cloudtraining.zuul.streetservice.model.Street;
import ru.yusdm.cloudtraining.zuul.streetservice.repo.StreetRepo;
import ru.yusdm.cloudtraining.zuul.streetservice.service.StreetLocalService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StreetLocalServiceImpl implements StreetLocalService {

    private StreetRepo streetRepo;

    @Autowired
    public StreetLocalServiceImpl(StreetRepo streetRepo) {
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
    public List<Street> findAllByCityId(long cityId) {
        return streetRepo.findAllByCityId(cityId);
    }

    @Override
    public void deleteById(Long id) {
        streetRepo.deleteById(id);
    }
}
