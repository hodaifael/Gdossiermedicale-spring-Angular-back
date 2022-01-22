package com.example.Gdossiermedicale.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
public class Patien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom;
    private  String prenom;

    @OneToOne(mappedBy = "patien")
    @JsonBackReference
    private Dossier rdv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Dossier getRdv() {
        return rdv;
    }

    public void setRdv(Dossier rdv) {
        this.rdv = rdv;
    }
}
