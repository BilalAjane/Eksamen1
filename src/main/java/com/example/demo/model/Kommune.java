package com.example.demo.model;

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

    @OneToMany(mappedBy = "kommune",cascade = CascadeType.ALL)
    private Set<Sogn> sogne;

    public Kommune() {
    }

    public Kommune(long kommunekode, String kommunenavn, Set<Sogn> sogne) {
        this.kommunekode = kommunekode;
        this.kommunenavn = kommunenavn;
        this.sogne = sogne;
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
