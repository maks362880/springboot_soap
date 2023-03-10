package com.maksimtebenkov.springboot.springboot_soap.services.impl;

import com.maksimtebenkov.springboot.springboot_soap.repository.GoodsRepository;
import com.maksimtebenkov.springboot.springboot_soap.entity.Goods;
import com.maksimtebenkov.springboot.springboot_soap.services.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository repository;

    public List<Goods> findAll() {
        return repository.findAll();
    }

    public Goods saveGoods(Goods goods) {
        return repository.save(goods);
    }

    public Goods getGoods(int id) {
        return repository.getReferenceById(id);
    }

    public void deleteGoods(int id) {
        repository.deleteById(id);
    }

    public int getGoodsCount(){return repository.getGoodsCount();}
}
