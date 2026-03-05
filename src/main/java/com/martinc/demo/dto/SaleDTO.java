package com.martinc.demo.dto;

import com.martinc.demo.model.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SaleDTO(

        @NotBlank
        Long id,

        @NotBlank
        String saleDate,

        @NotBlank
        Double total,

        @NotNull
        List<ProductDTO> Products,

        @NotNull
        Customer client
) { }
