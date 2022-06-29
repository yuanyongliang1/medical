package com.system.service.Impl;

import com.system.dao.ShopCarDao;
import com.system.pojo.Shopcar;
import com.system.service.ShopCarService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName ShopCarServiceImpl
 * @Description TODO
 * @Author 15135
 * @Date 2020/12/3 15:49
 **/
@Service
public class ShopCarServiceImpl implements ShopCarService {
    @Autowired
    ShopCarDao shopCarDao;
    @Override
    public int insert(Shopcar shopcar) {
        return shopCarDao.insert(shopcar);
    }

    @Override
    public Collection<Shopcar> selectAll(int user_id) {
        return shopCarDao.selectAll(user_id);
    }

    @Override
    public List<Shopcar> selectAllShopcar() {
        return shopCarDao.selectAllShopcar();
    }

    @Override
    public List<Shopcar> selectAllShopcar1(int user_id) {
        return shopCarDao.selectAllShopcar1(user_id);
    }

    @Override
    public Shopcar yanzheng(Shopcar shopcar) {
        return shopCarDao.yanzheng(shopcar);
    }

    @Override
    public int shopcarUpdate(Shopcar shopcar) {
        return shopCarDao.shopcarUpdate(shopcar);
    }

    @Override
    public int shopcarAdd(Integer user_id, Integer goods_id) {
        return shopCarDao.shopcarAdd(user_id,goods_id);
    }

    @Override
    public int shopcarSub(Integer user_id, Integer goods_id) {
        return shopCarDao.shopcarSub(user_id,goods_id);
    }

    @Override
    public int deleteShopCar(int goods_id, int user_id) {
        return shopCarDao.deleteShopCar(goods_id,user_id);
    }
}
