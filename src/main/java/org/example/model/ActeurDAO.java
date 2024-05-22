package org.example.model;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ActeurDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinema?characterEncoding=utf8";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    static Connection con = null;

    // Database Connection will use jdbc driver from the mysql connector jar
    public void Dbconnect() {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            // connection to mysql
//            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName("localhost");
            ds.setPort(3306);
            ds.setDatabaseName("cinema");
            ds.setUser("root");
            ds.setPassword("");
            con = ds.getConnection();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public List getActeurs(){
        List<Acteur> acteurs = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            String sqlQuery = "SELECT * FROM acteur";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            //process the result set
            while (resultSet.next()){

                Acteur act = new Acteur();
                act.setId(resultSet.getInt("id"));
                act.setNom(resultSet.getString("nom"));
                act.setPrenom(resultSet.getString("prenom"));
                act.setPhoto(resultSet.getString("photo"));
                acteurs.add(act);
            }

        } catch (Exception e){
            System.out.println("Erreur");
        }
        return acteurs;
    }

    //permet d'ajouter des données dans la base de donnee

    public void addActeur(Acteur act) {
        PreparedStatement preparedStatement = null;
        try {
            String insertQuery = "INSERT INTO acteur (nom, prenom, photo) VALUES (?, ?, ?)";
            preparedStatement = con.prepareStatement(insertQuery);

            preparedStatement.setString(1, act.getNom());
            preparedStatement.setString(2, act.getPrenom());
            preparedStatement.setString(3, act.getPhoto());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Inserted succefully");
            } else {
                System.out.println("Failed to insert data");
            }
            preparedStatement.close();
        } catch (Exception ex) {
        }
    }

///pour modifier la base de donnée
    public void updateActeur(int id, Acteur act) {
        PreparedStatement preparedStatement = null;
        try {
            String updateQuery = "UPDATE acteur SET nom = ? , prenom = ? , photo = ? WHERE id=? ";
            preparedStatement = con.prepareStatement(updateQuery);

            preparedStatement.setString(1, act.getNom());
            preparedStatement.setString(2, act.getPrenom());
            preparedStatement.setString(3, act.getPhoto());
            preparedStatement.setInt(4,id);
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("update succefully");
            } else {
                System.out.println("Failed to update data");
            }
            preparedStatement.close();
        } catch (Exception ex) {
        }}

        ///pour supprimer une donnée
        public static void deleteActeur(int id) {
            PreparedStatement preparedStatement = null;
            try {
                String deleteQuery = "DELETE FROM acteur WHERE id="+id;
                preparedStatement = con.prepareStatement(deleteQuery);
                System.out.println("élément supprimé");
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (Exception ex) {
            }
    }}

