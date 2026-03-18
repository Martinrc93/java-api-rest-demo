package com.martinc.demo.controller;

import com.martinc.demo.dto.ProductDTO;
import com.martinc.demo.service.product.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<ProductDTO>> productDTOList(@PageableDefault(page = 0, size = 10) Pageable pageable,
                                                           @RequestParam(required = false) Long minStock){

        return ResponseEntity.ok(productService.products(pageable, minStock));

    }

    @PutMapping("/update/{id}")
    public ProductDTO updateProduct(@Valid @PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("delete/")
    public void deleteProduct(@Valid @RequestBody Long id){
        productService.deleteProduct(id);
    }

}
