package com.course.rest.web.mappers;

import com.course.rest.domain.Customer;
import com.course.rest.web.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDTO mapCustomerToCustomerDTO(Customer customer);
    Customer mapCustomerDTOToCustomer(CustomerDTO customerDTO);
}
