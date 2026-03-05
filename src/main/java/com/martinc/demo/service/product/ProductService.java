package com.martinc.demo.service.product;


import com.martinc.demo.dto.ProductDTO;
import com.martinc.demo.mapper.ProductMapper;
import com.martinc.demo.model.Product;
import com.martinc.demo.repository.IProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements  IProductService {

    private final IProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO saveProduct(ProductDTO product) {

        Product productEntity = productMapper.toEntity(product);
        productRepository.save(productEntity);
        return productMapper.toDto(productEntity);

    }

    @Override
    public List<ProductDTO> products() {

        List<ProductDTO> listProducts;
        List<Product> products = productRepository.findAll();
        listProducts = products.stream().map(productMapper::toDto).toList();

        return listProducts;
    }

    @Override
    public ProductDTO getProduct(Long id) {

        Product product = productRepository.findById(id).orElse(null);
        return productMapper.toDto(product);

    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO product) {
        if ( this.getProduct(id) != null){

            Product productEntity = productMapper.toEntity(product);
            productRepository.save(productEntity);
            return productMapper.toDto(productEntity);

        }else{
            return null;
        }
    }
}
