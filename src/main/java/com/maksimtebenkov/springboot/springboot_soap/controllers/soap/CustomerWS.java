package com.maksimtebenkov.springboot.springboot_soap.controllers.soap;

import com.maksimtebenkov.springboot.springboot_soap.entity.Customer;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface CustomerWS {
    @WebMethod
    List<Customer> findAll();
}