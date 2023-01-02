package com.maksimtebenkov.springboot.springboot_soap.controllers.exeption_handling;

public class NoSuchCustomersExeption extends RuntimeException{
    public NoSuchCustomersExeption(String message) {
        super(message);
    }
}
