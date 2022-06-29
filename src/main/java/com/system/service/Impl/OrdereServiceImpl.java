package com.system.service.Impl;

import com.system.dao.OrderDao;
import com.system.pojo.Ordere;
import com.system.service.OrdereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author 15135
 * @Date 2020/12/2 10:07
 **/
@Service
public class OrdereServiceImpl implements OrdereService {
    @Autowired
    private OrderDao orderDao;


    @Override
    public int insertOrdere(Ordere ordere) {
        return orderDao.insertOrdere(ordere);
    }

    @Override
    public Collection<Ordere> selectAllOrder() {
        return orderDao.selectAllOrder();
    }

    @Override
    public Ordere OrdereById(int o_id) {
        return orderDao.OrdereById(o_id);
    }

    @Override
    public Collection<Ordere> OrdereUser(int user_id) {
        return orderDao.OrdereUser(user_id);
    }

    @Override
    public Collection<Ordere> OrdereUserPay(int user_id) {
        return orderDao.OrdereUserPay(user_id);
    }

    @Override
    public int updateOrderPay(Integer o_id) {
        return orderDao.updateOrderPay(o_id);
    }


    @Override
    public int updateOrder(Ordere ordere) {
        return orderDao.updateOrder(ordere);
    }

    @Override
    public int updateOrderStatus(Ordere ordere) {
        return orderDao.updateOrderStatus(ordere);
    }

    @Override
    public int deleteOrder(int o_id) {
        return orderDao.deleteOrder(o_id);
    }
}
