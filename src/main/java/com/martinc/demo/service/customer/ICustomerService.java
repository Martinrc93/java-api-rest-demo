package com.martinc.demo.service.customer;

import com.martinc.demo.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {

    List<CustomerDTO> customers();
    CustomerDTO getCustomer(Long id);
    CustomerDTO createCustomer(CustomerDTO customer);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);

}
