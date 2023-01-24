package com.maksimtebenkov.springboot.springboot_soap.controllers.soap.imp;

import com.maksimtebenkov.springboot.springboot_soap.controllers.soap.GoodsWS;
import com.maksimtebenkov.springboot.springboot_soap.entity.Goods;
import com.maksimtebenkov.springboot.springboot_soap.services.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GoodsWSImpl implements GoodsWS {

    private final GoodsService service;

    @Override
    public List<Goods> findAll() {
        return service.findAll();
    }
}
