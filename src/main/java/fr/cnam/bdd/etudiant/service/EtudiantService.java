package fr.cnam.bdd.etudiant.service;

import fr.cnam.bdd.etudiant.dao.EtudiantDAO;
import fr.cnam.bdd.etudiant.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudiantService {


    @Autowired
    private EtudiantDAO etudiantDAO;

    public List<Etudiant> getListEtudiants(){
        try {
            return etudiantDAO.getListEtudiant();
        } catch (SQLException e) {
            return Collections.emptyList() ;
        }

    }

    //TODO

    private Etudiant getEtudiant(String[] line) {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(line[0]);
        etudiant.setPrenom(line[1]);
        return etudiant ;

    }

    public Etudiant getEtudiantById(int idEtudiant) {

        try {
            return etudiantDAO.getEtudiantById(idEtudiant);
        } catch (SQLException e) {
            throw new RuntimeException(e) ;
        }
    }


}
