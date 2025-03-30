package com.gerald.accounts.mappers;

import com.gerald.accounts.dto.CustomerDto;
import com.gerald.accounts.entity.Customers;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@ToString
public class Mapper {

    public Customers mapToCustomerEntity(CustomerDto customerDto) {
        var customer = new Customers();
        customer.setFirstName(customerDto.firstName());
        customer.setLastName(customerDto.lastName());
        customer.setEmail(customerDto.email());
        customer.setMobileNumber(customerDto.mobileNumber());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Gerald");

        return customer;
    }
}
