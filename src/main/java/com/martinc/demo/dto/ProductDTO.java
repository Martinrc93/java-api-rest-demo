package com.martinc.demo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class ProductDTO {

    private Long id;

    private String name;

    private String brand;

    private Double price;

    private Double stock;

}
