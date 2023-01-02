package com.maksimtebenkov.springboot.springboot_soap.controllers.exeption_handling;

public class NoSuchSaleExeption extends RuntimeException{
    public NoSuchSaleExeption(String message) {
        super(message);
    }
}
