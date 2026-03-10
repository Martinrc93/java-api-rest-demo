package com.martinc.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductDTO(

        Long id,
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
        String name,

        @NotBlank(message = "La marca es obligatoria")
        @Size(max = 50, message = "La marca no puede superar los 50 caracteres")
        String brand,

        @NotNull(message = "El precio es obligatorio")
        @Positive(message = "El precio debe ser mayor a 0")
        Double price,

        @NotNull(message = "El stock es obligatorio")
        Long stock
){}