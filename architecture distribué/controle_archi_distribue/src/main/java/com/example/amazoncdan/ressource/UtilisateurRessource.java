package com.example.amazoncdan.ressource;
import com.example.amazoncdan.dto.UtilisateurDto;
import com.example.amazoncdan.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("Etudiant")
public class UtilisateurRessource {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("getallutilisateur")
    public ResponseEntity get(){
       return new ResponseEntity(utilisateurService.getAllUtilisateurs(), HttpStatus.OK);
    }

//    @GetMapping("countutilisateurstypes")
//    public ResponseEntity countutilisateurstypes(){
//        return new ResponseEntity(utilisateurService.countUtilisateursTypes(), HttpStatus.OK);
//    }

    @GetMapping("getutilisateur/{id}")
    public ResponseEntity getUtilisateurById(@PathVariable String id){

        Integer ID = null;
        try{
            ID = Integer.parseInt(id);
        } catch (NumberFormatException e){
            return new ResponseEntity("L'Id n'as pas le bon format", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(utilisateurService.getUtilisateurById( ID), HttpStatus.OK);
    }


    @GetMapping("getutilisateurdata/{id}")
    public ResponseEntity getutilisateurdata(@PathVariable String id){

        Integer ID;
        try{
            ID = Integer.parseInt(id);
        } catch (NumberFormatException e){
            return new ResponseEntity("L'Id n'as pas le bon format", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(utilisateurService.getUtilisateurData( ID), HttpStatus.OK);
    }

    @GetMapping("gettop3chauffeurs")
    public ResponseEntity gettop3chauffeurs(){
        return new ResponseEntity(utilisateurService.getTop3Chauffeurs(), HttpStatus.OK);
    }


}
