package com.maksimtebenkov.springboot.springboot_soap.controllers.soap.imp;

import com.maksimtebenkov.springboot.springboot_soap.controllers.soap.SaleWS;
import com.maksimtebenkov.springboot.springboot_soap.entity.Sale;

import com.maksimtebenkov.springboot.springboot_soap.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SaleWSImpl implements SaleWS {

    private final SaleService service;

    @Override
    public List<Sale> findAll() {
        return service.findAll();
    }
}
