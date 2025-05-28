package com.desafio.poi.service;

import org.springframework.stereotype.Service;

import com.desafio.poi.controller.dtos.PontoInteresseRequestDto;
import com.desafio.poi.controller.dtos.PontoInteresseResponseDto;
import com.desafio.poi.entity.PontoInteresse;
import com.desafio.poi.repository.PontoInteresseRepository;

@Service
public class PontoInteresseService {
    
    private final PontoInteresseRepository pontoInteresseRepository;

    public PontoInteresseService(PontoInteresseRepository pontoInteresseRepository)
    {
        this.pontoInteresseRepository = pontoInteresseRepository;
    }

    public PontoInteresseResponseDto cadastrarPontoInteresse(PontoInteresseRequestDto pontoInteresseRequestDto)
    {
        PontoInteresse pontoInteresse = new PontoInteresse(pontoInteresseRequestDto.nome(),
        pontoInteresseRequestDto.x(),
        pontoInteresseRequestDto.y());

        pontoInteresseRepository.save(pontoInteresse);

        return new PontoInteresseResponseDto(pontoInteresse);
    }
}
