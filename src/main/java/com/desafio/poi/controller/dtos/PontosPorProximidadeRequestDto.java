package com.desafio.poi.controller.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record PontosPorProximidadeRequestDto(
    
    @PositiveOrZero(message = "O valor da coordenada não pode ser negativo")
    @NotNull(message = "O valor da coordenada X é obrigatório")
    int x,

    @PositiveOrZero(message = "O valor da coordenada não pode ser negativo")
    @NotNull(message = "O valor da coordenada X é obrigatório")
    int y,

    @PositiveOrZero(message = "O valor da distancia max não pode ser negativo")
    @NotNull(message = "O valor da distancia maxima é obrigatório")
    int distMaxima) {
    
}
