package com.maksimtebenkov.springboot.springboot_soap.controllers.soap;

import com.maksimtebenkov.springboot.springboot_soap.entity.Customer;
import com.maksimtebenkov.springboot.springboot_soap.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerWSImpl implements CustomerWS {

    private final CustomerService service;

    @Override
    public List<Customer> findAll() {
        return service.findAll();
    }
}
