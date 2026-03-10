package com.martinc.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private LocalDate saleDate;

    private Double total;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToOne
    private Customer client;

}
