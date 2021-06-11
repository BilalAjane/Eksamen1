package com.example.demo.service;

import com.example.demo.model.Kommune;
import com.example.demo.repository.KommuneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KommuneServiceImpl implements KommuneService{

    @Autowired
    private KommuneRepo kommuneRepo;

    @Override
    public List<Kommune> getAllKommuner() {
        return (List<Kommune>) kommuneRepo.findAll();
    }

    @Override
    public void saveKommune(Kommune kommune) {
        this.kommuneRepo.save(kommune);
    }

    @Override
    public void deleteKommuneById(long id) {
        this.kommuneRepo.deleteById(id);
    }
}
