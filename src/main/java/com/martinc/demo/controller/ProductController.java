package com.martinc.demo.controller;

import com.martinc.demo.dto.ProductDTO;
import com.martinc.demo.service.product.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @GetMapping("/list")
    public List<ProductDTO> productDTOList(){
        return productService.products();
    }

    @PostMapping("/create")
    public ProductDTO createProduct(ProductDTO productDTO){
        return productService.saveProduct(productDTO);
    }

    @PutMapping("/update/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("delete/")


}
