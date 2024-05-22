package org.example;
import javax.swing.*; //permet les fenetre de dialogue
import org.example.controller.ActeurController;
import org.example.model.Acteur;
import org.example.model.ActeurDAO;

import java.util.List;

public class ActMVC {


    public static void main(String[] args) {
        ActeurController ac = new ActeurController();
        ActeurDAO acteurDAO = new ActeurDAO();
        acteurDAO.Dbconnect();


         //permet d afficher la liste des acteurs

        List<Acteur> acteurs = acteurDAO.getActeurs();
        for (Acteur act: acteurs){
            System.out.println(act.getNom());
            ac.addActeur(act);
        }


       //permet d inserer un nouvel acteur via fenetre de dialogue

        String name = JOptionPane.showInputDialog(null, "Veuillez saisir le nom de l'acteur");
        String fname = JOptionPane.showInputDialog(null, "Veuillez saisir le prénom de l'acteur");
        String photo = JOptionPane.showInputDialog(null, "Veuillez saisir le nom de son fichier photo");


        String actName = String.valueOf(name);
        String actFName = String.valueOf(fname);
        String actPhoto = String.valueOf(photo);

 // modif

        acteurDAO.addActeur(new Acteur(1, actName, actFName, actPhoto));

        acteurDAO.updateActeur(2, new Acteur("nommodifié","prénommodifié","photomodifée"));


        ////////////////////////////////////////////








                        //////////////////////////////////////////////

//        ActeurController ac = new ActeurController();
//        ac.addActeur(new Acteur(1, "Belmondo", "Jean-Paul", "PB.jpg"));
//        ac.addActeur(new Acteur(2, "Reno", "Jean", "reno.jpg"));
//        ac.addActeur(new Acteur(3, "Dujardin", "Jean", "duj1.jpg"));
//        ac.afficheActeur(2);
//        ac.afficheActeurs();

        //ac.getActeurs();
        ac.afficheActeur(1);  //affiche un acteur grace a son id.
    }
}