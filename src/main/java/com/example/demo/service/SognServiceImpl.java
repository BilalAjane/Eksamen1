package com.example.demo.service;

import com.example.demo.model.Sogn;
import com.example.demo.repository.SognRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SognServiceImpl implements SognService {

    @Autowired
    private SognRepo sognRepo;

    @Override
    public List<Sogn> getAllSogn() {
        return sognRepo.findAll();
    }

    @Override
    public void saveSogn(Sogn sogn) {
        this.sognRepo.save(sogn);
    }


    @Override
    public Sogn getSognById(long id) {
        Optional<Sogn> sogner = sognRepo.findById(id);
        Sogn sogn = null;
        if(sogner.isPresent()){
            sogn = sogner.get();
        } else {
            throw new RuntimeException("Sogn id : " + id + " eksisterer ikke");
        } return sogn;
    }

     @Override
    public void deleteSognById(long id) {
        this.sognRepo.deleteById(id);
     }



}
