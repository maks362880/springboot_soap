package com.maksimtebenkov.springboot.springboot_soap.dao;

import com.maksimtebenkov.springboot.springboot_soap.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
