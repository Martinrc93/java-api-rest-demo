package com.martinc.demo.controller;


import com.martinc.demo.dto.CustomerDTO;
import com.martinc.demo.service.customer.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }

    @GetMapping("/list")
    public List<CustomerDTO> listCustomer(){
        return customerService.customers();
    }

    @PostMapping("/create")
    public CustomerDTO createCustomer (@RequestBody CustomerDTO customerDTO){
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping("/update/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestBody Long id) {
        customerService.deleteCustomer(id);
    }

}
