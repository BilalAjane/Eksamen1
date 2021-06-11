package com.example.demo.service;

import com.example.demo.model.Kommune;

import java.util.List;
import java.util.Optional;

public interface KommuneService {
    List<Kommune> getAllKommuner();
    void saveKommune(Kommune kommune);
    void deleteKommuneById(long id);

}
