package fr.cnam.bdd.etudiant.dao;

import fr.cnam.bdd.etudiant.model.Etudiant;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EtudiantDAO {

    public List<Etudiant> getListEtudiant() throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/bdd2", "root", "root");

        PreparedStatement statement = connection.prepareStatement(
                "SELECT nom, prenom, sexe, date_naiss, idEtudiant FROM etudiant");
        ResultSet resultSet = statement.executeQuery();

        List<Etudiant> resultat = new ArrayList<>();
        while (resultSet.next()) {
            Etudiant etudiant = new Etudiant();
            etudiant.setPrenom(resultSet.getString("prenom"));
            etudiant.setNom(resultSet.getString("nom"));
            etudiant.setDateNaissance(resultSet.getDate("date_naiss"));
            etudiant.setSexe(resultSet.getString("sexe"));
            etudiant.setId(resultSet.getInt("idEtudiant"));
            resultat.add(etudiant);

        }

        // traitement
        resultSet.close();
        connection.close();
        return resultat;
    }


    //TODO :
    public Etudiant getEtudiantById(int idEtudiant) throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/bdd2", "root", "root");

        PreparedStatement statement = connection.prepareStatement(
                "SELECT nom, prenom, sexe, date_naiss, idEtudiant FROM etudiant where idEtudiant=" + idEtudiant);

        ResultSet resultSet = statement.executeQuery();


        if (!resultSet.next()) {
            return null;


        } else {
            Etudiant etudiant = new Etudiant();
            etudiant.setPrenom(resultSet.getString("prenom"));
            etudiant.setNom(resultSet.getString("nom"));
            etudiant.setDateNaissance(resultSet.getDate("date_naiss"));
            etudiant.setSexe(resultSet.getString("sexe"));
            etudiant.setId(resultSet.getInt("idEtudiant"));
            return etudiant;
        }
    }


    public static void main(String[] args) throws SQLException {
        EtudiantDAO etudiantDAO = new EtudiantDAO();
        etudiantDAO
                .getListEtudiant()
                .forEach(System.out::println);
        ;
    }
}
