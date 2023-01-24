package com.maksimtebenkov.springboot.springboot_soap.services;

import com.maksimtebenkov.springboot.springboot_soap.entity.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> findAll();

    Goods saveGoods(Goods goods);

    Goods getGoods(int id);

    void deleteGoods(int id);

    int getGoodsCount();
}
