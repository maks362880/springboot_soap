package com.maksimtebenkov.springboot.springboot_soap.services;

import com.maksimtebenkov.springboot.springboot_soap.dao.CustomerRepository;
import com.maksimtebenkov.springboot.springboot_soap.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }
}
