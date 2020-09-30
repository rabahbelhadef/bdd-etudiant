package fr.cnam.bdd.etudiant.dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DataSourceProvider {

    String dbUrl = "jdbc:mysql://localhost:3306/bdd2";
    String bdUser= "root";
    String dbPassword = "root";

    Connection getConnection() throws SQLException {
        return DriverManager
                .getConnection(dbUrl, bdUser, dbPassword) ;
    }
}
