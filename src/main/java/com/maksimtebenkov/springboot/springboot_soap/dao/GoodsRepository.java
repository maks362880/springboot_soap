package com.maksimtebenkov.springboot.springboot_soap.dao;

import com.maksimtebenkov.springboot.springboot_soap.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer> {
}
