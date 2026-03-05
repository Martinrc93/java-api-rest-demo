package com.martinc.demo.mapper;

import com.martinc.demo.dto.ProductDTO;
import com.martinc.demo.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

    Product toEntity(ProductDTO productDTO);
    void updateEntityFromDto(ProductDTO productDto, @MappingTarget Product productEntity);
}
