package com.martinc.demo.service.product;

import com.martinc.demo.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProductService {

    ProductDTO saveProduct (ProductDTO product);
    Page<ProductDTO> products(Pageable pageable, Long minStock);
    ProductDTO getProduct(Long id);
    void deleteProduct(Long id);
    ProductDTO updateProduct(Long id, ProductDTO product);
    boolean discountStockById(Long id, Long stock);

}
