package com.desafio.poi.controller.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record PontoInteresseRequestDto(
    
    @NotEmpty(message = "O nome do Ponto de Interesse é obrigatório")
    String nome,

    @PositiveOrZero(message = "O valor da coordenada não pode ser negativo")
    @NotNull(message = "A coordenada X é obrigatória para cadastrar um novo ponto de interesse")
    int x,

    @PositiveOrZero(message = "O valor da coordenada não pode ser negativo")
    @NotNull(message = "A coordenada Y é obrigatória para cadastrar um novo ponto de interesse")
    int y) {
    
}
