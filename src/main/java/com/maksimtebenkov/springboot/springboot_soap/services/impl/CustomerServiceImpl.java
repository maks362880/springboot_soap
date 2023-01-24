package com.maksimtebenkov.springboot.springboot_soap.services.impl;

import com.maksimtebenkov.springboot.springboot_soap.repository.CustomerRepository;
import com.maksimtebenkov.springboot.springboot_soap.entity.Customer;
import com.maksimtebenkov.springboot.springboot_soap.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer getCustomer(int id) {
        return repository.getReferenceById(id);
    }

    public void deleteCustomer(int id) {
        repository.deleteById(id);
    }


}
