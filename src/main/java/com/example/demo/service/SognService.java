package com.example.demo.service;

import com.example.demo.model.DTO.KommuneDTO;
import com.example.demo.model.DTO.SognDTO;
import com.example.demo.model.Kommune;
import com.example.demo.model.Sogn;
import com.example.demo.repository.KommuneRepo;
import com.example.demo.repository.SognRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.*;

@Service
public class SognService {

    @Autowired
    private SognRepo sognRepo;

    @Autowired
    private KommuneRepo kommuneRepo;

    public List<SognDTO> getAllSogn() {
        ArrayList<SognDTO> sognDTOS = new ArrayList<>();
        List<Sogn> sognList = sognRepo.findAll();

        for (Sogn sogn : sognList) {
            sognDTOS.add(new SognDTO(
                    sogn.getSognkode(),
                    sogn.getSognnavn(),
                    sogn.getSmitteniveau(),
                    sogn.getNedlukningsdato(),
                    sogn.getKommune().getKommunenavn(),
                    sogn.getId()
            ));
        }
        return sognDTOS;
    }

    public void saveSogn(Sogn sogn) {
        this.sognRepo.save(sogn);
    }

    public void deleteSognById(long id) {
        this.sognRepo.deleteById(id);
    }

    public Sogn getSognById(long id) {
        Optional<Sogn> sogne = sognRepo.findById(id);
        Sogn sogn;
        if (sogne.isPresent()) {
            sogn = sogne.get();
        } else {
            throw new RuntimeException("Sogn id : " + id + " eksisterer ikke");
        }
        return sogn;
    }

    public Set<Sogn> findAllSogne() {
        Set<Sogn> sognSet = new HashSet<>();
        for (Sogn sogn : sognRepo.findAll()) {
            sognSet.add(sogn);
        }
        return sognSet;
    }

    public SognDTO createSogn(long sognkode, String kommunenavn, String sognnavn, long smitteniveau, LocalDate nedlukningsdato) {

        Optional<Sogn> sognOptional = sognRepo.findSognBySognnavn(sognnavn);

        if (sognOptional.isEmpty()) {

            Kommune kommune = getKommune(kommuneRepo.findKommuneByKommunenavn(kommunenavn), kommunenavn);
            Sogn sogn = new Sogn(sognkode, sognnavn, smitteniveau, nedlukningsdato, kommune);
            kommune.addSogn(sogn);

            kommuneRepo.save(kommune);

            return new SognDTO(sogn.getSognkode(), sogn.getSognnavn(), sogn.getSmitteniveau(), sogn.getNedlukningsdato(), kommune.getKommunenavn(), sogn.getId());
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Sogn already exists - Check the name or use UPDATE to change the data");
        }
    }

    public Kommune getKommune(Optional<Kommune> optionalKommune, String kommunenavn) {
        if (optionalKommune.isEmpty()) {
            Kommune nyKommune = new Kommune(kommunenavn);
            return nyKommune;
        } else {
            return optionalKommune.get();
        }
    }

    public SognDTO updateSogn(long id, LocalDate nedlukning, long smitteniveau) {
        Optional<Sogn> optionalSogn = sognRepo.findById(id);

        if (optionalSogn.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sogn doesn't exist");
        } else {
            optionalSogn.get().setNedlukningsdato(nedlukning);
            optionalSogn.get().setSmitteniveau(smitteniveau);
            sognRepo.save(optionalSogn.get());

            return new SognDTO(
                    optionalSogn.get().getSognkode(),
                    optionalSogn.get().getSognnavn(),
                    optionalSogn.get().getSmitteniveau(),
                    optionalSogn.get().getNedlukningsdato(),
                    optionalSogn.get().getKommune().getKommunenavn(),
                    optionalSogn.get().getId()
            );
        }
    }

    public ResponseEntity<String> deleteSogn(long id) {

        Optional<Sogn> optionalSogn = sognRepo.findById(id);

        if (optionalSogn.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sogn not found");
        } else {
            sognRepo.deleteById(optionalSogn.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body("{ 'msg' : 'deleteddd'}");
        }
    }
}