package com.example.demo.model.DTO;

public class KommuneDTO {

    private long kommuneid;
    private String kommunenavn;
    private long samletsmitteniveau;
    private long kommunekode;

    public KommuneDTO(String kommunenavn, long kommunekode, long kommuneid) {
        this.kommunenavn = kommunenavn;
        this.kommunekode = kommunekode;
        this.kommuneid = kommuneid;
    }

    public void totalSmitteniveau(long smitteniveau) {
        samletsmitteniveau += smitteniveau;
    }

    public String getKommunenavn() {
        return kommunenavn;
    }

    public void setKommunenavn(String kommunenavn) {
        this.kommunenavn = kommunenavn;
    }

    public long getSamletsmitteniveau() {
        return samletsmitteniveau;
    }

    public void setSamletsmitteniveau(long samletsmitteniveau) {
        this.samletsmitteniveau = samletsmitteniveau;
    }

    public long getKommunekode() {
        return kommunekode;
    }

    public void setKommunekode(long kommunekode) {
        this.kommunekode = kommunekode;
    }

    public long getKommuneid() {
        return kommuneid;
    }

    public void setKommuneid(long kommuneid) {
        this.kommuneid = kommuneid;
    }
}
