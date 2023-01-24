package com.maksimtebenkov.springboot.springboot_soap.services.impl;


import com.maksimtebenkov.springboot.springboot_soap.repository.PositionListRepository;
import com.maksimtebenkov.springboot.springboot_soap.entity.PositionList;
import com.maksimtebenkov.springboot.springboot_soap.services.PositionListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionListServiceImpl implements PositionListService {
    private final PositionListRepository repository;

    public List<PositionList> findAll() {
        return repository.findAll();
    }

    public PositionList savePositionList(PositionList positionList) {
        return repository.save(positionList);
    }

    public PositionList getPositionList(int id) {
        return repository.getReferenceById(id);
    }

    public void deletePositionList(int id) {
        repository.deleteById(id);
    }


}
