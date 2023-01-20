package com.example.demo.service;

import com.example.demo.dto.EtudiantDto;
import com.example.demo.dto.InputEtudiantDto;
import com.example.demo.entity.EtudiantEntity;

import java.time.LocalDate;

public interface IServiceEtudiant {

    Integer calculerAge(LocalDate date_naisse);

    EtudiantDto toDto(EtudiantEntity entity);

    Integer ajouterEtudiant (InputEtudiantDto dto);

    Boolean exist(Integer id);

    Boolean delete(Integer id);

}
