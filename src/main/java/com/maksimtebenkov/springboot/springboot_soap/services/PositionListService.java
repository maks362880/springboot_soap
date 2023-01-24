package com.maksimtebenkov.springboot.springboot_soap.services;

import com.maksimtebenkov.springboot.springboot_soap.entity.PositionList;

import java.util.List;

public interface PositionListService {
    List<PositionList> findAll();

    PositionList savePositionList(PositionList positionList);

    PositionList getPositionList(int id);

    void deletePositionList(int id);
}
