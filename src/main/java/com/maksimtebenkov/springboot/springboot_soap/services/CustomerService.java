package com.maksimtebenkov.springboot.springboot_soap.services;

import com.maksimtebenkov.springboot.springboot_soap.entity.Customer;
import com.maksimtebenkov.springboot.springboot_soap.repository.CustomerRepository;

import java.util.List;

public interface CustomerService
{

    List<Customer> findAll();

    Customer saveCustomer(Customer customer);

     Customer getCustomer(int id);

    void deleteCustomer(int id);
}
