package com.martinc.demo.repository;

import com.martinc.demo.model.Product;
import com.martinc.demo.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {

}
