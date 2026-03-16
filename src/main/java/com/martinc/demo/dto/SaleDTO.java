package com.martinc.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record SaleDTO(
        Long id,

        LocalDate saleDate,

        @NotNull(message = "El total no puede ser nulo")
        Double total,

        @NotNull(message = "El cliente no puede ser nulo")
        CustomerDTO customer,

        @Valid
        @NotNull(message = "La lista de detalles no puede ser nula")
        List<SaleDetailDTO> details
) {
}
