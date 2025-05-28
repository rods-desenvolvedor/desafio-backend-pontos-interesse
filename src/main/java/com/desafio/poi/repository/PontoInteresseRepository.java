package com.desafio.poi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.poi.entity.PontoInteresse;

public interface PontoInteresseRepository extends JpaRepository<PontoInteresse, UUID>{
    
}
