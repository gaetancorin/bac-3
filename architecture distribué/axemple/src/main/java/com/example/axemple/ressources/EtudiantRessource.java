package com.example.axemple.ressources;

import com.example.axemple.dto.EtudiantDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("Etudiant")
public class EtudiantRessource {

    @GetMapping("Example")
    public String HelloWorld(){
        return "Bonjour";
    }

    @GetMapping("Example2")
    public ResponseEntity<String> Hello2(){
        ResponseEntity reponse = new ResponseEntity("deuxième example", HttpStatus.OK);
                return reponse;
    }

    @GetMapping("Example3/{prenom}")
    public ResponseEntity<String> example3(@PathVariable String prenom){
        ResponseEntity reponse = new ResponseEntity("je m'appelle "+prenom, HttpStatus.OK);
        return reponse;
    }

    @GetMapping("Example4")
    public ResponseEntity<String> example4(@RequestParam String prenom, int age){
        String message ="je m'appelle "+prenom+" j'ai "+age+" ans";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("Example5")
    public ResponseEntity<String> toto(@RequestBody EtudiantDto Dto){
        int age = Period.between(Dto.getDate_naissance(), LocalDate.now()).getYears();
        String message = "je m'appelle "+Dto.getPrenom()+" "+Dto.getNom()+" j'ai "+age+" ans";
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

}
