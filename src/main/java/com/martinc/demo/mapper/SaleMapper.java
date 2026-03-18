package com.martinc.demo.mapper;

import com.martinc.demo.dto.SaleDTO;
import com.martinc.demo.model.Sale;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {SaleDetailMapper.class, CustomerMapper.class})
public interface SaleMapper {

    @Mapping(target = "saleDetails", source = "saleDetails")
    SaleDTO toDto(Sale sale);

    @Mapping(target = "saleDetails", source = "saleDetails")
    Sale toEntity(SaleDTO saleDTO);

    @AfterMapping
    default void setSaleDetailOnSale(@MappingTarget Sale sale){
        if (sale.getSaleDetails() != null){
            sale.getSaleDetails().forEach(saleDetail -> saleDetail.setSale(sale));
        }
    }

    void updateEntityFromDto(SaleDTO saleDto,@MappingTarget Sale saleEntity);

}
