package com.example.demo.controller;


import com.example.demo.model.DTO.SognDTO;
import com.example.demo.model.Sogn;
import com.example.demo.service.SognService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    SognService sognService;

    @GetMapping("/findAllSogne")
    public List<Sogn> index() {
        return new ArrayList<>(sognService.findAllSogne());
    }


    @PostMapping("/createSogne/{sognkode}/{sognnavn}/{smitteniveau}/{nedlukning}/{kommunenavn}")
    public ResponseEntity<SognDTO> create(
            @PathVariable int sognkode,
            @PathVariable String sognnavn,
            @PathVariable int smitteniveau,
            @PathVariable String nedlukning,
            @PathVariable String kommunenavn

    ) {
        try {
            LocalDate nedlukningsDato = LocalDate.parse(nedlukning);
            return new ResponseEntity<>(sognService.createSogn(sognkode, kommunenavn, sognnavn, smitteniveau, nedlukningsDato), HttpStatus.CREATED);
        } catch (DateTimeParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You have to use the YYYY-MM-DD format for date.");
        }
    }



/*
    @PutMapping("/updateSogne")
    public Sogn update(@RequestBody SognDTO sognDTO) throws Exception{
        return sognService.update(sognDTO);
    }

 */

    @PutMapping("/updateSogn/{id}/{nedlukning}/{smitteniveau}")
    public ResponseEntity<SognDTO> updateSogn(
            @PathVariable long id,
            @PathVariable String nedlukning,
            @PathVariable long smitteniveau
    ) {
        try {
            LocalDate nedlukningsDato = LocalDate.parse(nedlukning);
            return new ResponseEntity<>(sognService.updateSogn(id, nedlukningsDato, smitteniveau), HttpStatus.OK);
        } catch (DateTimeParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You have to use the YYYY-MM-DD format for date.");
        }

    }


    @DeleteMapping("/deleteSogne/{id}")
    public void deleteSogn(@PathVariable long id){
        sognService.deleteSogn(id);
    }



}
