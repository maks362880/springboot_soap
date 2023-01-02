package com.maksimtebenkov.springboot.springboot_soap.controllers.rest;

import com.maksimtebenkov.springboot.springboot_soap.controllers.exeption_handling.CustomerIncorrectData;
import com.maksimtebenkov.springboot.springboot_soap.controllers.exeption_handling.NoSuchCustomersExeption;
import com.maksimtebenkov.springboot.springboot_soap.entity.Customer;
import com.maksimtebenkov.springboot.springboot_soap.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping("/customers/")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }


    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            throw new NoSuchCustomersExeption("There are no customers with id = " + id +" in Database");
        }
        return customer;
    }

    @PostMapping("/customer")
    public Customer addNewCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable int id) throws NoSuchCustomersExeption {
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            throw new NoSuchCustomersExeption("There are no employee with id = " + id +" in Database");
        }
        customerService.deleteCustomer(id);
        return "Customer with ID = " + id + " was deleted";
    }

    @ExceptionHandler
    public ResponseEntity<CustomerIncorrectData> handleExeption(NoSuchCustomersExeption exception){
        CustomerIncorrectData data = new CustomerIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

}
