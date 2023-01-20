package com.example.demo.ressource;

import com.example.demo.dto.EtudiantDto;
import com.example.demo.dto.InputEtudiantDto;
import com.example.demo.entity.EtudiantEntity;
import com.example.demo.enumeration.ClasseIPI;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.service.IServiceEtudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("Etudiant")
public class EtudiantRessource {

    @Autowired
    private EtudiantRepository repository;

    @Autowired
    private IServiceEtudiant serviceEtudiant;

    @GetMapping("get/{id}")
    public ResponseEntity get(@PathVariable String id){

        Integer ID = null;
        try{
            ID = Integer.parseInt(id);
        } catch (NumberFormatException e){
            return new ResponseEntity("L'Id n'as pas le bon format", HttpStatus.BAD_REQUEST);
        }

        if (!serviceEtudiant.exist(ID)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        try{
            EtudiantEntity entity = repository.findById(ID).get();
        } catch (Exception e){
            return new ResponseEntity("Le serveur SQL a émis une exception", HttpStatus.BAD_REQUEST);
        }

        EtudiantEntity entity = repository.findById(ID).get();
        return new ResponseEntity(serviceEtudiant.toDto(entity), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity ajouter(@RequestBody InputEtudiantDto dto){
        // on verifie la date
        LocalDate date;
        try{
            LocalDate.parse(dto.getDate());
        }catch (DateTimeParseException e){
            return new ResponseEntity("la date est incorrect", HttpStatus.BAD_REQUEST);
        }
        // on verifie la classe
        try {
            ClasseIPI.valueOf(dto.getClasse());
        } catch (IllegalArgumentException e){
            return new ResponseEntity("la classe est incorrect", HttpStatus.BAD_REQUEST);
        }

        Integer ID = serviceEtudiant.ajouterEtudiant(dto);

        if (null == ID){
            return new ResponseEntity("l'enregistrement ne c'est pas fait", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(ID, HttpStatus.OK);

    }

    @GetMapping("delete/{id}")
    public ResponseEntity supprimer (@PathVariable String id){
        Integer ID;
        try {
            ID = Integer.parseInt(id);
        } catch (NumberFormatException e){
            return new ResponseEntity("l'ID n'a pas le bon format", HttpStatus.BAD_REQUEST);
        }

        if (!serviceEtudiant.exist(ID)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        boolean result = serviceEtudiant.delete(ID);
        if (!result){
            return new ResponseEntity("l'etudiant na pas été supprimer", HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity(HttpStatus.OK);

    }
}
