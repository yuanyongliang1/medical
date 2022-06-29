package com.system.service;

import com.system.pojo.Ordere;

import java.util.Collection;

/**
 * @ClassName OrdereService
 * @Description TODO
 * @Author 15135
 * @Date 2020/12/2 10:07
 **/
public interface OrdereService {

    int insertOrdere(Ordere ordere);

    Collection<Ordere> selectAllOrder();

    Ordere OrdereById(int o_id);

    Collection<Ordere> OrdereUser(int user_id);

    Collection<Ordere> OrdereUserPay(int user_id);

    int updateOrderPay(Integer o_id);

    int updateOrder(Ordere ordere);

    int updateOrderStatus(Ordere ordere);

    int deleteOrder(int o_id);
}
