package fr.cnam.bdd.etudiant.resource;

import fr.cnam.bdd.etudiant.model.Etudiant;
import fr.cnam.bdd.etudiant.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@RestController
public class EtudiantResource {

    @Autowired
    private EtudiantService etudiantService ;

    @RequestMapping(value = "/etudiants", method = RequestMethod.GET)
    public List<Etudiant> getListEtudiants(){
        return etudiantService.getListEtudiants() ;
    }


    @RequestMapping(value = "/etudiants/{id}", method = RequestMethod.GET)
    public Etudiant getEtudiantById(@PathParam("id") Integer id){
        Etudiant etudiant = new Etudiant();
        etudiant.setId(id);
        etudiant.setNom("BELHADEF");
        etudiant.setPrenom("Rbaah");
        etudiant.setDateNaissance(new Date());
        etudiant.setSexe("Homme") ;
        return etudiant ;
    }


}
