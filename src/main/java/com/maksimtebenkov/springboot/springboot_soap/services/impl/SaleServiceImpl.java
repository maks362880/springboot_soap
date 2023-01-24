package com.maksimtebenkov.springboot.springboot_soap.services.impl;

import com.maksimtebenkov.springboot.springboot_soap.repository.SaleRepository;
import com.maksimtebenkov.springboot.springboot_soap.entity.Sale;
import com.maksimtebenkov.springboot.springboot_soap.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository repository;

    public List<Sale> findAll() {
        return repository.findAll();
    }

    public Sale saveSale(Sale sale) {
        return repository.save(sale);
    }

    public Sale getSale(int id) {
        return repository.getReferenceById(id);
    }

    public void deleteSale(int id) {
        repository.deleteById(id);
    }
}
