package com.maksimtebenkov.springboot.springboot_soap.dao;

import com.maksimtebenkov.springboot.springboot_soap.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
