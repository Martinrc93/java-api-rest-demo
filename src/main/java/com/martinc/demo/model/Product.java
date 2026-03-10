package com.martinc.demo.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 50)
    private String brand;

    @Column(nullable = false, precision = 2)
    private Double price;

    @Column(nullable = false)
    private Long stock = 0L;

}
