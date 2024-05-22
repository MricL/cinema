package org.example.view;

import org.example.model.Acteur;
import org.example.model.ActeurDAO;

import java.util.List;

public class ActeurView {
    public void afficheActeurs(List<Acteur> acteurs){
        System.out.println("Liste : ");
        for(Acteur acteur:acteurs) {
            System.out.println(acteur.getNom());
        }
    }

    public void afficheActeur(int id,List<Acteur> acteurs) {
        for (Acteur acteur : acteurs) {
            if (acteur.getId() == id) {
                System.out.println(acteur.getNom());
            }

        }
    }
    /// pour suppr une donnee
    public static void supprActeur(int id, List<Acteur> acteurs){
        for (Acteur acteur : acteurs) {
            if (acteur.getId() == id) {
            ActeurDAO.deleteActeur(id);
            }}}

}
