package com.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.config.CommonResult;
import com.system.pojo.Medica;
import com.system.pojo.Ordere;
import com.system.service.MedicatypeService;
import com.system.service.OrdereService;
import com.system.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author 15135
 * @Date 2020/12/2 10:09
 **/
@Controller
@CrossOrigin
public class OrdereController {
    @Autowired
    private OrdereService orderService;
    @Autowired
    ShopCarService shopCarService;
    @Autowired
    MedicatypeService medicatypeService;

    @RequestMapping("/insertOrder")
    @ResponseBody
    public int insertOrder(Ordere ordere,int goods_id,int goods_number,int m_id,int m_num){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        ordere.setO_time(dateFormat.format(date));
        ordere.setPay_status("0");
        ordere.setPost_status("0");
        System.out.println(ordere);
        int i = orderService.insertOrdere(ordere);
        int y = shopCarService.deleteShopCar(goods_id,ordere.getUser_id());
        int z = medicatypeService.updateMedicanum(m_num,goods_number,m_id);
//        int x =
        return z;
    }

    @RequestMapping("/selectAllOrder")
    @ResponseBody
    public Map<String,Object> selectAllOrder(@RequestParam(value = "page",defaultValue = "1")Integer pn,
                                             @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        PageHelper.startPage(pn,limit);
        Collection<Ordere> order = orderService.selectAllOrder();
        PageInfo page = new PageInfo((List) order,limit);
        System.out.println(order);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("code",0);
        pageMap.put("msg","");
        pageMap.put("data",page.getList());
        pageMap.put("count",page.getTotal());

        return pageMap;
    }

    @RequestMapping("/selectOrderById")
    @ResponseBody
    public Ordere selectCommonsenseById(Integer o_id){
        Ordere ordere = orderService.OrdereById(o_id);
        return ordere;
    }

    @RequestMapping("/selectOrderUser")
    @ResponseBody
    public Collection selectOrderUser(Integer user_id){
        Collection<Ordere> ordere = orderService.OrdereUser(user_id);
        return ordere;
    }

    @RequestMapping("/selectOrderPay")
    @ResponseBody
    public Collection selectOrderPay(Integer user_id){
        Collection<Ordere> ordere = orderService.OrdereUserPay(user_id);
        return ordere;
    }

    @RequestMapping("/updateOrderPay")
    @ResponseBody
    public int updateOrderPay(Integer o_id){
        System.out.println(o_id);
        int i = orderService.updateOrderPay(o_id);
        System.out.println(i);
        return i;
    }

    @RequestMapping("/updateOrder")
    @ResponseBody
    public int updateOrder(Ordere ordere){
        int i = orderService.updateOrder(ordere);
        return i;
    }

    @RequestMapping("/updateOrderStatus")
    @ResponseBody
    public int updateOrderStatus(Ordere ordere){
        System.out.println(ordere);
        System.out.println(ordere.getPay_status());
        String  sta = ordere.getPay_status();
        int statu = Integer.parseInt(sta);
        if(statu == 0){
            return 0;
        }else{
            System.out.println(sta.equals(0));
            int i = orderService.updateOrderStatus(ordere);
            return i;
        }
    }

    @RequestMapping("/deleteOrder")
    @ResponseBody
    public int deleteOrder(int o_id){
        int i = orderService.deleteOrder(o_id);
        return i;
    }
}
