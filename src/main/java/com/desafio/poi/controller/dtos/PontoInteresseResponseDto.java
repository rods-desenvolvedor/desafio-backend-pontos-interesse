package com.desafio.poi.controller.dtos;

import com.desafio.poi.entity.PontoInteresse;

public record PontoInteresseResponseDto(String nome, int x, int y) {
    
    public PontoInteresseResponseDto(PontoInteresse pontoInteresse)
    {
        this(pontoInteresse.getNome(), pontoInteresse.getX(), pontoInteresse.getY());
    }
}
