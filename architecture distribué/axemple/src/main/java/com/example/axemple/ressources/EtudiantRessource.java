package com.example.axemple.ressources;

import com.example.axemple.dto.EtudiantDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

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

    @GetMapping("Example6")
    public ResponseEntity<String> example6(@RequestBody Double[] arrayDouble){
        Double total = 0.0;
        for (int i=0; i<arrayDouble.length; i++) {
            total += arrayDouble[i];
        }
        Double moyenne = total / arrayDouble.length;
        String message = "Le total de la liste est "+total+" et sa moyenne est de "+moyenne;
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("Example7")
    public ResponseEntity<String> example7(@RequestBody Double[] arrayDouble, @RequestParam String maxOrMin){
        Double valMax = arrayDouble[0];
        Double valMin = arrayDouble[0];
        for (int i=1; i<arrayDouble.length; i++) {
            if(arrayDouble[i] > valMax){
                valMax = arrayDouble[i];
            }
            if(arrayDouble[i] < valMin){
                valMin = arrayDouble[i];
            }
        }
        String message = "Il faut donner un paramètre max ou min";
        if(Objects.equals(maxOrMin, "max")){
            message = "La valeur max du tableau est "+ valMax;
        }
        if(Objects.equals(maxOrMin, "min")){
            message = "La valeur min du tableau est "+ valMin;;
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
