package com.example.demo.service;

import com.example.demo.model.DTO.KommuneDTO;
import com.example.demo.model.Kommune;
import com.example.demo.model.Sogn;
import com.example.demo.repository.KommuneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KommuneService{

    @Autowired
    private KommuneRepo kommuneRepo;

    public List<KommuneDTO> getAllKommuner() {
        ArrayList<KommuneDTO> kommuneDTOS = new ArrayList<>();
        List<Kommune> kommuneListe = kommuneRepo.findAll();

        for (Kommune kommune : kommuneListe) {
            KommuneDTO kommuneDTO = new KommuneDTO(kommune.getKommunenavn(),kommune.getKommunekode(),kommune.getId());

            for (Sogn sogn : kommune.getSogne()) {
                kommuneDTO.totalSmitteniveau(sogn.getSmitteniveau());
            }

            kommuneDTOS.add(kommuneDTO);

        }

        return kommuneDTOS;
    }

    public void saveKommune(Kommune kommune) {
        this.kommuneRepo.save(kommune);
    }

    public void deleteKommuneById(long id) {
        this.kommuneRepo.deleteById(id);
    }


}
