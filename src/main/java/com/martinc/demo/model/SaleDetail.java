package com.martinc.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales_details")
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    //@Column(nullable = false)
    //@Min(value = 1, message = "The amount must be greater than 0")
    private Long amount;

    //@Column(nullable = false)
    //@Min(value = 0, message = "El precio no puede ser negativo")
    private BigDecimal price;

}
