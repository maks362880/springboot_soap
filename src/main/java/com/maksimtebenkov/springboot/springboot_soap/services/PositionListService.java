package com.maksimtebenkov.springboot.springboot_soap.services;


import com.maksimtebenkov.springboot.springboot_soap.dao.PositionListRepository;
import com.maksimtebenkov.springboot.springboot_soap.entity.PositionList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionListService {
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
