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

    @GetMapping("countutilisateurstypes")
    public ResponseEntity countutilisateurstypes(){
        return new ResponseEntity(utilisateurService.countUtilisateursTypes(), HttpStatus.OK);
    }


}
