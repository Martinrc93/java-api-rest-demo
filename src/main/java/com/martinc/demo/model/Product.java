package com.martinc.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.util.List;

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

    @Column(nullable = false, precision = 10, scale = 2)
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Check(constraints = "stock >= 0")
    private BigDecimal price;

    @Column(nullable = false)
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Check(constraints = "stock >= 0")
    private Long stock = 0L;

    @OneToMany(mappedBy = "product")
    private List<SaleDetail> saleDetails;
}
