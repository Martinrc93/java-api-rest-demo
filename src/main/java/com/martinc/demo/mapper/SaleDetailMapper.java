package com.martinc.demo.mapper;

import com.martinc.demo.dto.SaleDetailDTO;
import com.martinc.demo.model.SaleDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface SaleDetailMapper {

    @Mapping(target = "saleId", source = "sale.id")
    @Mapping(target = "product", source = "product") // Aseguramos que mapee el producto
    SaleDetailDTO toDto(SaleDetail saleDetail);

    @Mapping(target = "sale", ignore = true)
    SaleDetail toEntity(SaleDetailDTO saleDetailDTO);

}