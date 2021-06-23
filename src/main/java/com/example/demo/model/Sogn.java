package com.example.demo.model;

import com.example.demo.model.DTO.SognDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sogne")
public class Sogn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long sognkode;
    private String sognnavn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate nedlukningsdato;
    private long smitteniveau;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "kommune_id")
    private Kommune kommune;

    public Sogn() {
    }

    public Sogn(long sognkode, String sognnavn, long smitteniveau, LocalDate nedlukningsdato, Kommune kommune) {
        this.sognkode = sognkode;
        this.sognnavn = sognnavn;
        this.smitteniveau = smitteniveau;
        this.nedlukningsdato = nedlukningsdato;
        this.kommune = kommune;
    }

    public Sogn(SognDTO sognDTO, Kommune kommunekode){
        this.sognnavn = sognDTO.getSognnavn();
        this.sognkode = sognDTO.getSognkode();
        this.kommune = kommunekode;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSognkode() {
        return sognkode;
    }

    public void setSognkode(long sognekode) {
        this.sognkode = sognekode;
    }

    public String getSognnavn() {
        return sognnavn;
    }

    public void setSognnavn(String sognnavn) {
        this.sognnavn = sognnavn;
    }

    public long getSmitteniveau() {
        return smitteniveau;
    }

    public void setSmitteniveau(long smitteniveu) {
        this.smitteniveau = smitteniveu;
    }

    public LocalDate getNedlukningsdato() {
        return nedlukningsdato;
    }

    public void setNedlukningsdato(LocalDate nedlukningsdato) {
        this.nedlukningsdato = nedlukningsdato;
    }

    public Kommune getKommune() { return kommune; }

    public void setKommune(Kommune kommune) { this.kommune = kommune; }
}
