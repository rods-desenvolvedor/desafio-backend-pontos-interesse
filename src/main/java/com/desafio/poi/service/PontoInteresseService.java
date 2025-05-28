package com.desafio.poi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.poi.controller.dtos.PontoInteresseRequestDto;
import com.desafio.poi.controller.dtos.PontoInteresseResponseDto;
import com.desafio.poi.controller.dtos.PontosPorProximidadeRequestDto;
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

    public List<PontoInteresseResponseDto> listarPontosInteresse()
    {
        List<PontoInteresse> pontosInteresse = pontoInteresseRepository.findAll();

        return pontosInteresse.stream().map(PontoInteresseResponseDto::new).toList();
    }

    public List<PontoInteresseResponseDto> listarPontosPorProximidade(PontosPorProximidadeRequestDto pontosPorProximidadeRequestDto)
    {
        List<PontoInteresse> pontosInteresse = pontoInteresseRepository.findAll();

        List<PontoInteresse> pontosPorProximidade = pontosInteresse.stream()
        .filter(ponto -> calcularDistancia(ponto.getX(), pontosPorProximidadeRequestDto.x(),
        ponto.getY(),pontosPorProximidadeRequestDto.y()) <= pontosPorProximidadeRequestDto.distMaxima()).toList();

        return pontosPorProximidade.stream().map(PontoInteresseResponseDto::new).toList();
    }

    public Double calcularDistancia(int x1, int x2, int y1, int y2)
    {
        Double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return dist;
    }


    // Apenas para facilitar os testes
    public void apagarTodosOsPontos()
    {
        pontoInteresseRepository.deleteAll();
    }
}
