package com.maksimtebenkov.springboot.springboot_soap.controllers.rest;

import com.maksimtebenkov.springboot.springboot_soap.entity.Customer;
import com.maksimtebenkov.springboot.springboot_soap.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @RequestMapping("/customers/")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
