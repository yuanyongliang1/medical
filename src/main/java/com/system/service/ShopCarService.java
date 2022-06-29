package com.system.service;

import com.system.pojo.Shopcar;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName ShopCarService
 * @Description TODO
 * @Author 15135
 * @Date 2020/12/3 15:49
 **/
public interface ShopCarService {
    int insert(Shopcar shopcar);

    Collection<Shopcar> selectAll(int user_id);

    List<Shopcar> selectAllShopcar();

    List<Shopcar> selectAllShopcar1(int user_id);

    Shopcar yanzheng(Shopcar shopcar);

    int shopcarUpdate(Shopcar shopcar);

    int shopcarAdd(Integer user_id, Integer goods_id);

    int shopcarSub(Integer user_id, Integer goods_id);

    int deleteShopCar(int goods_id,int user_id);
}
