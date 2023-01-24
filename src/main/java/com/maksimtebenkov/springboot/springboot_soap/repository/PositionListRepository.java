package com.maksimtebenkov.springboot.springboot_soap.repository;

import com.maksimtebenkov.springboot.springboot_soap.entity.PositionList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionListRepository extends JpaRepository<PositionList,Integer> {
}
