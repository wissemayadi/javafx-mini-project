/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnexion {

    final String URL = "jdbc:mysql://localhost:3306/emploi";
    final String LOGIN = "root";
    final String PASSWORD = "";
    private Connection cnx;

    private static MaConnexion instance;

    private MaConnexion() {
        try {
            cnx = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Connexion établie");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static MaConnexion getInstance() {//data source
        if (instance == null) {
            instance = new MaConnexion();
        }
        return instance;
    }
    
}