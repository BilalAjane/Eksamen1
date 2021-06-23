package com.example.demo.model;

import com.example.demo.model.DTO.KommuneDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "kommune")
public class Kommune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long kommunekode;
    private String kommunenavn;

    @JsonManagedReference
    @OneToMany(mappedBy = "kommune",cascade = CascadeType.ALL)
    private Set<Sogn> sogne;

    public Kommune() {
    }

    public Kommune(String kommunenavn) {
        this.kommunenavn = kommunenavn;
    }

    public Kommune(long kommunekode, String kommunenavn, Set<Sogn> sogne) {
        this.kommunekode = kommunekode;
        this.kommunenavn = kommunenavn;
        this.sogne = sogne;
    }

    public Set<Sogn> getSogne() {
        return sogne;
    }

    public void setSogne(Set<Sogn> sogne) {
        this.sogne = sogne;
    }

    public void addSogn(Sogn sogn) {
        sogne.add(sogn);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getKommunekode() {
        return kommunekode;
    }

    public void setKommunekode(long kommunekode) {
        this.kommunekode = kommunekode;
    }

    public String getKommunenavn() {
        return kommunenavn;
    }

    public void setKommunenavn(String navn) {
        this.kommunenavn = navn;
    }
}
