package com.martinc.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record SaleDetailDTO(

        Long saleId,

        @NotNull(message = "El producto es obligatorio")
        ProductDTO product,
        
        @NotNull(message = "La cantidad es obligatoria")
        @Min(value = 1, message = "La cantidad debe ser mayor a 0")
        Long amount,

        BigDecimal price
) {}
