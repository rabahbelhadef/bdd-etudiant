package fr.cnam.bdd.etudiant.resource;

import fr.cnam.bdd.etudiant.model.Etudiant;
import fr.cnam.bdd.etudiant.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Etudiant getEtudiantById(@PathVariable(value="id") Integer id){
        return etudiantService.getEtudiantById(id);

    }


}
