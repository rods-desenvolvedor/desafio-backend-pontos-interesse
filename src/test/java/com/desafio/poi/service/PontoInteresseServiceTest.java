package com.desafio.poi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.desafio.poi.controller.dtos.PontoInteresseRequestDto;
import com.desafio.poi.controller.dtos.PontoInteresseResponseDto;
import com.desafio.poi.controller.dtos.PontosPorProximidadeRequestDto;
import com.desafio.poi.entity.PontoInteresse;
import com.desafio.poi.repository.PontoInteresseRepository;


@ExtendWith(MockitoExtension.class)
public class PontoInteresseServiceTest {

    @Mock
    private PontoInteresseRepository pontoInteresseRepository;

    @InjectMocks
    private PontoInteresseService pontoInteresseService;

    @Test
    void deveCadastrarPontoDeInteresse()
    {
        PontoInteresse pontoInteresse = new PontoInteresse(UUID.randomUUID(), 
        "Lanchonete", 15, 20);

        when(pontoInteresseRepository.save(any(PontoInteresse.class))).thenReturn(pontoInteresse);

        PontoInteresseResponseDto resultado = pontoInteresseService.cadastrarPontoInteresse(
            new PontoInteresseRequestDto(pontoInteresse.getNome(), pontoInteresse.getX(), pontoInteresse.getY())
        );

        assertEquals("Lanchonete", resultado.nome());
    }

    @Test
    void deveListarPontosDeInteresse() 
    {
        List<PontoInteresse> listaMockada = List.of(
            new PontoInteresse(UUID.randomUUID(), "Lanchonete", 10, 20),
            new PontoInteresse(UUID.randomUUID(), "Farmacia", 15 ,24)
        );

        when(pontoInteresseRepository.findAll()).thenReturn(listaMockada);

        List<PontoInteresseResponseDto> resultado = pontoInteresseService.listarPontosInteresse();

        assertEquals(2, resultado.size());
        assertEquals("Lanchonete", resultado.get(0).nome());
        verify(pontoInteresseRepository , times(1)).findAll();
    }

    @Test
    void deveListarPontosPorProximidade()
    {

        List<PontoInteresse> dados = List.of(
            new PontoInteresse(UUID.randomUUID(), "Lanchonete", 27, 12),
            new PontoInteresse(UUID.randomUUID(), "Posto", 31 ,18),
            new PontoInteresse(UUID.randomUUID(), "Joalheria", 15 ,12),
            new PontoInteresse(UUID.randomUUID(), "Floricultura", 19 ,21),
            new PontoInteresse(UUID.randomUUID(), "Pub", 12 ,8),
            new PontoInteresse(UUID.randomUUID(), "Supermercado", 23 ,6),
            new PontoInteresse(UUID.randomUUID(), "Churrascaria", 28 ,2)
        );

        List<PontoInteresseResponseDto> listaMockada = List.of(
            new PontoInteresseResponseDto("Lanchonete", 27, 12),
            new PontoInteresseResponseDto( "Joalheria", 15 ,12),
            new PontoInteresseResponseDto( "Pub", 12 ,8),
            new PontoInteresseResponseDto( "Supermercado", 23 ,6)
        );


        when(pontoInteresseRepository.findAll()).thenReturn(dados);

        List<PontoInteresseResponseDto> resultado = pontoInteresseService.listarPontosPorProximidade(new PontosPorProximidadeRequestDto(20,10, 10));
    
        assertEquals(4, resultado.size());
        assertEquals("Lanchonete", resultado.get(0).nome());
        
    
    }
    
}
