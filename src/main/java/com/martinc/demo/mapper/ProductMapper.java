package com.martinc.demo.mapper;

import com.martinc.demo.dto.ProductDTO;
import com.martinc.demo.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

    Product toEntity(ProductDTO productDTO);

}
