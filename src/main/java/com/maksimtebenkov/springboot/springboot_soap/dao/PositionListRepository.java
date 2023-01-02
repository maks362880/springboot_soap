package com.maksimtebenkov.springboot.springboot_soap.dao;

import com.maksimtebenkov.springboot.springboot_soap.entity.PositionList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionListRepository extends JpaRepository<PositionList,Integer> {
}
