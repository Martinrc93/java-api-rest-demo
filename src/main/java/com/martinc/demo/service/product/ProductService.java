package com.martinc.demo.service.product;


import com.martinc.demo.dto.ProductDTO;
import com.martinc.demo.exception.ResourceNotFoundException;
import com.martinc.demo.mapper.ProductMapper;
import com.martinc.demo.model.Product;
import com.martinc.demo.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService implements  IProductService {

    private final IProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductDTO saveProduct(ProductDTO product) {

        Product productEntity = productMapper.toEntity(product);
        productRepository.save(productEntity);
        return productMapper.toDto(productEntity);

    }

    @Override
    public Page<ProductDTO> products (Pageable pageable) {

        Page<Product> productsEntity = productRepository.findAll(pageable);
        return productsEntity.map(productMapper::toDto);

    }

    @Override
    public ProductDTO getProduct(Long id) {

        Product product = productRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " not found"));

        return productMapper.toDto(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product with id: " + id + " not found");
        }
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ProductDTO updateProduct(Long id, ProductDTO product) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        productMapper.updateEntityFromDto(product, existingProduct);
        Product savedProduct = productRepository.save(existingProduct);

        return productMapper.toDto(savedProduct);
    }
}
