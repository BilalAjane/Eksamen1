package com.example.demo.model.DTO;

import java.time.LocalDate;

public class SognDTO {

    private long sognid;
    private long sognkode;
    private String sognnavn;
    private long smitteniveau;
    private LocalDate nedlukningsdato;
    private String kommune;
    private boolean nedlukket;


    public SognDTO(long sognkode, String sognnavn, long smitteniveau, LocalDate nedlukningsdato, String kommune,long sognid) {
        this.sognkode = sognkode;
        this.sognnavn = sognnavn;
        this.smitteniveau = smitteniveau;
        this.nedlukningsdato = nedlukningsdato;
        this.kommune = kommune;
        this.sognid = sognid;
        this.nedlukket = LocalDate.now().isAfter(nedlukningsdato) || LocalDate.now().isEqual(nedlukningsdato);
    }

    public long getSognkode() {
        return sognkode;
    }

    public void setSognkode(long sognkode) {
        this.sognkode = sognkode;
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

    public void setSmitteniveau(long smitteniveau) {
        this.smitteniveau = smitteniveau;
    }

    public LocalDate getNedlukningsdato() {
        return nedlukningsdato;
    }

    public void setNedlukningsdato(LocalDate nedlukningsdato) {
        this.nedlukningsdato = nedlukningsdato;
    }

    public String getKommune() {
        return kommune;
    }

    public void setKommune(String kommune) {
        this.kommune = kommune;
    }

    public boolean isNedlukket() {
        return nedlukket;
    }

    public void setNedlukket(boolean nedlukket) {
        this.nedlukket = nedlukket;
    }

    public long getSognid() {
        return sognid;
    }

    public void setSognid(long sognid) {
        this.sognid = sognid;
    }
}
