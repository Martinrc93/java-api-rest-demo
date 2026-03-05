package com.martinc.demo.service.customer;

import com.martinc.demo.dto.CustomerDTO;
import com.martinc.demo.mapper.CustomerMapper;
import com.martinc.demo.model.Customer;
import com.martinc.demo.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> customers() {
        return customerRepository.findAll().stream().map(customerMapper::toDto).toList();
    }

    @Override
    public CustomerDTO getCustomer(Long id) {
        return customerRepository.findById(id).map(customerMapper::toDto).orElse(null);
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customer) {

        Customer customerEntity = customerMapper.toEntity(customer);
        customerRepository.save(customerEntity);
        return customerMapper.toDto(customerEntity);

    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {

        Customer existingCustomer = customerRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Customer not found " + id));

        customerMapper.updateEntityFromDto(customerDTO, existingCustomer);
        customerRepository.save(existingCustomer);
        return customerMapper.toDto(existingCustomer);

    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
