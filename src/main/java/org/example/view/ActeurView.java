package org.example.view;

import org.example.model.Acteur;

import java.util.List;

public class ActeurView {
    public void afficheActeurs(List<Acteur> acteurs){
        System.out.println("Liste : ");
        for(Acteur acteur:acteurs) {
            System.out.println(acteur.getNom());
        }
    }

    public void afficheActeur(List<Acteur> acteurs,int id){
        for(Acteur acteur:acteurs) {
            if (acteur.getId() == id){
                System.out.println(acteur.getNom());
            }

        }
    }
}
