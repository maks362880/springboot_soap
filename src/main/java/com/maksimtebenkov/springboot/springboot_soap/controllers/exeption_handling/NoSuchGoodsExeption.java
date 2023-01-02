package com.maksimtebenkov.springboot.springboot_soap.controllers.exeption_handling;

public class NoSuchGoodsExeption extends RuntimeException {
    public NoSuchGoodsExeption(String message) {
        super(message);
    }
}
