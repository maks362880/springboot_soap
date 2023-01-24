package com.maksimtebenkov.springboot.springboot_soap.repository;

import com.maksimtebenkov.springboot.springboot_soap.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer> {

    @Query(value = "SELECT MAX(id) FROM goods", nativeQuery = true)
    int getGoodsCount();
}
