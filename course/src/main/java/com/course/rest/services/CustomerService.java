package com.course.rest.services;

import com.course.rest.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID customerId);
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(UUID customerId, CustomerDTO customerDTO);
    void deleteCustomer(UUID customerId);
}
