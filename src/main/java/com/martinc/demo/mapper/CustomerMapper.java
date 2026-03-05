package com.martinc.demo.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.martinc.demo.dto.CustomerDTO;
import com.martinc.demo.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDto(Customer customer);

    Customer toEntity(CustomerDTO customerDTO);

    void updateEntityFromDto(CustomerDTO customerDto, @MappingTarget Customer customerEntity);


}
