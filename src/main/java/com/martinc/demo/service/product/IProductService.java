package com.martinc.demo.service.product;

import com.martinc.demo.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    ProductDTO saveProduct (ProductDTO product);
    List<ProductDTO> products();
    ProductDTO getProduct(Long id);
    void deleteProduct(Long id);
    ProductDTO updateProduct(Long id, ProductDTO product);

}
