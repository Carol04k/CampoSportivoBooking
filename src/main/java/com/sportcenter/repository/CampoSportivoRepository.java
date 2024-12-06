package com.sportcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportcenter.model.CampoSportivo;


public interface CampoSportivoRepository extends JpaRepository<CampoSportivo, Long> {
    
}
