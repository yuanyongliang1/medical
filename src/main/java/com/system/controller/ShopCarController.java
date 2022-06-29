package com.system.controller;

import com.system.pojo.Commonsense;
import com.system.pojo.Shopcar;
import com.system.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@CrossOrigin
public class ShopCarController {
    @Autowired
    ShopCarService shopCarService;


    @RequestMapping("/insertShopCar")
    @ResponseBody
    public int insertShopCar(Shopcar shopcar){
        System.out.println(shopcar);
        System.out.println(shopcar.getUser_id());
        if(shopcar.getUser_id() == 0){
            return 0;
        }
        Shopcar shopcar1 = shopCarService.yanzheng(shopcar);
        System.out.println(shopcar1);
        if(shopcar1!=null){
            int i =shopCarService.shopcarUpdate(shopcar);
            return i;
        }
        int i = shopCarService.insert(shopcar);
        return i;
    }

    @RequestMapping("/selectShopCar")
    @ResponseBody
    public Collection selectShopCar(int user_id){
        Collection<Shopcar> shopcar = shopCarService.selectAll(user_id);
        return shopcar;
    }

    @RequestMapping("/selectAllShopCar")
    @ResponseBody
    public Collection selectAllShopCar(){
        Collection<Shopcar> shopcar = shopCarService.selectAllShopcar();
        return shopcar;
    }

    @RequestMapping("/selectAllShopCar1")
    @ResponseBody
    public Collection selectAllShopCar1(Integer user_id){
        System.out.println(user_id);
        Collection<Shopcar> shopcar = shopCarService.selectAllShopcar1(user_id);
        return shopcar;
    }

    @RequestMapping("/ShopAdd")
    @ResponseBody
    public int  ShopAdd(Integer user_id,Integer goods_id){
        int i = shopCarService.shopcarAdd(user_id,goods_id);
        return i;
    }
    @RequestMapping("/ShopSub")
    @ResponseBody
    public int  ShopSub(Integer user_id,Integer goods_id){
        int i = shopCarService.shopcarSub(user_id,goods_id);
        return i;
    }

}
