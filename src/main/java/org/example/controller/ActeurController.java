package org.example.controller;
import org.example.model.Acteur;
import org.example.model.ActeurDAO;
import org.example.view.ActeurView;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ActeurController {

    public List<Acteur> Acteurs;
    private ActeurView viewActeur;
    private ActeurDAO acteurDAO;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinema";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public ActeurController() {
        this.Acteurs = new ArrayList<>();
        this.viewActeur = new ActeurView();
        this.acteurDAO = new ActeurDAO();
    }

    public void addActeur(Acteur act){
        this.Acteurs.add(act);
    }

    public List<Acteur> getActeurs(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM acteur";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            //process the result set
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nom");
                String fname = resultSet.getString("prenom");
                String photo = resultSet.getString("photo");
                Acteurs.add(new Acteur(id, name, fname, photo));
                System.out.println("name: " + name + " ajouté à la liste");
                System.out.println("ID " + id + ", name: " + name + " " + fname + " " + photo);
            }

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.out.println("Erreur");
            System.exit(0);
        }
        return Acteurs;
    }

    public void afficheActeurs(){
        viewActeur.afficheActeurs(Acteurs);
    }

//    public void afficheActeur(int id){
//        viewActeur.afficheActeur(id,this.Acteurs);
//    }//pour update



    public void afficheActeur(int id){
        Acteur acteur = acteurDAO.getActeur(id);

        if (acteur != null) {
            viewActeur.afficheActeur(acteur);
        } else {             System.out.println("Actor not found with ID: " + id);         }
    }

    public void supprActeur(int id) {ActeurView.supprActeur(id,Acteurs);} ///pour delete



}
