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
