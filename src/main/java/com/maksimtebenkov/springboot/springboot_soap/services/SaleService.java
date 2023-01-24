package com.maksimtebenkov.springboot.springboot_soap.services;

import com.maksimtebenkov.springboot.springboot_soap.entity.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> findAll();

    Sale saveSale(Sale sale);

    Sale getSale(int id);

    void deleteSale(int id);
}
