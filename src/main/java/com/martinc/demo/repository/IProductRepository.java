package com.martinc.demo.repository;

import com.martinc.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository <Product, Long> {
}
