package com.martinc.demo.repository;

import com.martinc.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository <Product, Long> {

    Page<Product> findByStockLessThan(Pageable pageable, Long stock);

    Product getById(Long id);

}
