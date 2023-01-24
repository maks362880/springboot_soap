package com.maksimtebenkov.springboot.springboot_soap.controllers.soap.imp;

import com.maksimtebenkov.springboot.springboot_soap.controllers.soap.PositionListWS;
import com.maksimtebenkov.springboot.springboot_soap.entity.PositionList;
import com.maksimtebenkov.springboot.springboot_soap.services.PositionListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class PositionListWSImpl implements PositionListWS {

    private final PositionListService service;

    @Override
    public List<PositionList> findAll() {
        return service.findAll();
    }
}
