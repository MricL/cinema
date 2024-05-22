package org.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Modele de MVC
public class Acteur {
    private int id;
    private String nom;
    private String prenom;
    private String photo;

    public Acteur(int id, String nom, String prenom, String photo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
    }

    public Acteur() {

    }

    public Acteur( String nom, String prenom, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getPhoto() {
        return photo;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
