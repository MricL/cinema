package org.example;
import java.sql.*;

public class Main {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinema";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM acteur";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            //process the result set
            while (resultSet.next()){
                // Retrieve dat from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nom");
                String fname = resultSet.getString("prenom");
                String photo = resultSet.getString("photo");
                System.out.println("ID " + id + ", name: " + name + " " + fname + " " + photo);
            }
            if (connection != null) {
                System.out.println("Connected to the database");
            } else {
                System.out.println("Failed to establish connection");
            }
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.out.println("Erreur");
            System.exit(0);
        }
    }
}