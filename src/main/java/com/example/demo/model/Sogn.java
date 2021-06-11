package com.example.demo.model;

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
    private long smitteniveau;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate nedlukningsdato;

    @ManyToOne
    @JoinColumn(name = "kommune_id")
    private Kommune kommune;

    public Sogn() {
    }

    public Sogn(long id, long sognkode, String sognnavn, long smitteniveau, LocalDate nedlukningsdato, Kommune kommune) {
        this.id = id;
        this.sognkode = sognkode;
        this.sognnavn = sognnavn;
        this.smitteniveau = smitteniveau;
        this.nedlukningsdato = nedlukningsdato;
        this.kommune = kommune;
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
}
