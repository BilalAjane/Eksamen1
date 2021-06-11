package com.example.demo.service;

import com.example.demo.model.Sogn;

import java.util.List;

public interface SognService {
    List<Sogn> getAllSogn();
    void saveSogn(Sogn sogn);
    Sogn getSognById (long id);
    void deleteSognById(long id);

}
