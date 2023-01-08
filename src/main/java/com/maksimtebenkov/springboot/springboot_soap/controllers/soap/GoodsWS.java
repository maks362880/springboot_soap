package com.maksimtebenkov.springboot.springboot_soap.controllers.soap;

import com.maksimtebenkov.springboot.springboot_soap.entity.Goods;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface GoodsWS {

    @WebMethod
    List<Goods> findAll();
}


