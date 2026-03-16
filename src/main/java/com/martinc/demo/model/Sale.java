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

    @OneToMany(mappedBy = "sale", fetch = FetchType.EAGER , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleDetail> saleDetails;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
