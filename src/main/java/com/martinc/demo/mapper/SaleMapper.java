package com.martinc.demo.mapper;

import com.martinc.demo.dto.SaleDTO;
import com.martinc.demo.model.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(source = "saleDate", target = "saleDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "Products", target = "Products")

    SaleDTO toDto(Sale sale);

    Sale toEntity(SaleDTO saleDTO);

    void updateEntityFromDto(SaleDTO saleDto,@MappingTarget Sale saleEntity);

}
