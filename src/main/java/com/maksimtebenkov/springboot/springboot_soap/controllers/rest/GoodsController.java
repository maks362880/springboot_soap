package com.maksimtebenkov.springboot.springboot_soap.controllers.rest;

import com.maksimtebenkov.springboot.springboot_soap.controllers.exeption.GoodsIncorrectData;
import com.maksimtebenkov.springboot.springboot_soap.controllers.exeption.NoSuchObjectExсeption;
import com.maksimtebenkov.springboot.springboot_soap.entity.Goods;
import com.maksimtebenkov.springboot.springboot_soap.services.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @RequestMapping("/goods/")
    public ResponseEntity<List<Goods>> findAll() {
        return ResponseEntity.ok(goodsService.findAll());
    }

    @GetMapping("/goods/{id}")
    public Goods getGoods(@PathVariable int id) {
        Goods goods = goodsService.getGoods(id);
        if (goods == null) {
            throw new NoSuchObjectExсeption("There are no goods with id = " + id +" in Database");
        }
        return goods;
    }

    @PostMapping("/goods")
    public Goods addNewGoods(@RequestBody Goods goods) {
        goodsService.saveGoods(goods);
        return goods;
    }

    @PutMapping("/goods")
    public Goods updateGoods(@RequestBody Goods goods) {
        goodsService.saveGoods(goods);
        return goods;
    }

    @DeleteMapping("/goods/{id}")
    public String deleteGoods(@PathVariable int id) throws NoSuchObjectExсeption {
        Goods goods = goodsService.getGoods(id);
        if (goods == null) {
            throw new NoSuchObjectExсeption("There are no goods with id = " + id +" in Database");
        }
        goodsService.deleteGoods(id);
        return "Goods with ID = " + id + " was deleted";
    }

    @ExceptionHandler
    public ResponseEntity<GoodsIncorrectData> handleExeption(NoSuchObjectExсeption exception){
        GoodsIncorrectData data = new GoodsIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

}
