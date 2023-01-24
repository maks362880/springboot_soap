package com.maksimtebenkov.springboot.springboot_soap.services.impl;

import com.maksimtebenkov.springboot.springboot_soap.entity.Goods;
import com.maksimtebenkov.springboot.springboot_soap.services.DiscountScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class DiscountSchedulerImpl implements DiscountScheduler {
    private final GoodsServiceImpl goodsService;

    public DiscountSchedulerImpl(GoodsServiceImpl goodsService) {
        this.goodsService = goodsService;
    }

 //   @Scheduled(initialDelay = 5, fixedRate = "${schedule.discount.time}", timeUnit = TimeUnit.MINUTES)
 @Scheduled(initialDelay = 5, fixedRate = 60, timeUnit = TimeUnit.MINUTES)
    public void generateGoodsDiscount() {
        int maxGoodsID = goodsService.getGoodsCount();
        int discount = (int) (Math.random() * 5 + 5);//random discount from 5% to 10%
        int randGoodsID = (int) (Math.random() * maxGoodsID);
        Goods goods = goodsService.getGoods(randGoodsID);
        goods.setProductDiscountPercent(discount);
        goodsService.saveGoods(goods);
    }
}
