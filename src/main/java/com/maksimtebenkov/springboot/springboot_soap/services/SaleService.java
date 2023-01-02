package com.maksimtebenkov.springboot.springboot_soap.services;

import com.maksimtebenkov.springboot.springboot_soap.dao.SaleRepository;
import com.maksimtebenkov.springboot.springboot_soap.entity.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

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
