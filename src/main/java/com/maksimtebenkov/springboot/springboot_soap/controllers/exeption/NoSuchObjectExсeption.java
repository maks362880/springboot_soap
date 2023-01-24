package com.maksimtebenkov.springboot.springboot_soap.controllers.exeption;

public class NoSuchObjectExсeption extends RuntimeException{
    public NoSuchObjectExсeption(String message) {
        super(message);
    }
}
