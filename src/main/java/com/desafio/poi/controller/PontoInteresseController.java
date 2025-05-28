package com.desafio.poi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.poi.controller.dtos.PontoInteresseRequestDto;
import com.desafio.poi.controller.dtos.PontoInteresseResponseDto;
import com.desafio.poi.service.PontoInteresseService;

@RestController
@RequestMapping("/api/ponto-interesse")
public class PontoInteresseController {

    private final PontoInteresseService pontoInteresseService;

    public PontoInteresseController(PontoInteresseService pontoInteresseService)
    {
        this.pontoInteresseService = pontoInteresseService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PontoInteresseResponseDto> cadastrarPontoInteresse(@RequestBody PontoInteresseRequestDto pontoInteresseRequestDto)
    {
        PontoInteresseResponseDto pontoInteresseResponseDto = pontoInteresseService.cadastrarPontoInteresse(pontoInteresseRequestDto);

        return ResponseEntity.ok().body(pontoInteresseResponseDto);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PontoInteresseResponseDto>> listarPontosInteresse()
    {
        List<PontoInteresseResponseDto> pontosInteresseResponseDtos = pontoInteresseService.listarPontosInteresse();
        return ResponseEntity.ok().body(pontosInteresseResponseDtos);
    }
    
}
