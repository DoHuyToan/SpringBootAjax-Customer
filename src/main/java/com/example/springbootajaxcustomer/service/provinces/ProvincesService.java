package com.example.springbootajaxcustomer.service.provinces;

import com.example.springbootajaxcustomer.model.Provinces;
import com.example.springbootajaxcustomer.repository.IProvincesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvincesService implements IProvincesService{

    @Autowired
    private IProvincesRepository provincesRepository;

    @Override
    public Iterable<Provinces> findAll() {
        return provincesRepository.findAll();
    }

    @Override
    public Optional<Provinces> findById(Long id) {
        return provincesRepository.findById(id);
    }

    @Override
    public void save(Provinces provinces) {
        provincesRepository.save(provinces);
    }

    @Override
    public void remove(Long id) {
        provincesRepository.deleteById(id);
    }
}
