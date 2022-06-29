package com.system.dao;

import com.system.pojo.Commonsense;
import com.system.pojo.Comuser;
import com.system.pojo.Ordere;
import com.system.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName OrderDao
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/27 15:38
 **/
@Mapper
public interface OrderDao {

    /**
     * 插入订单
     */
    @Insert("insert into ordere values(#{o_id},#{o_time},#{shr_name},#{shr_address},#{shr_phone},#{total_price},#{pay_status}" +
            ",#{post_status},#{user_id})")
    int insertOrdere(Ordere ordere);
    /**
     * 查询订单
     * @return
     */
    @Select("select * from ordere")
    Collection<Ordere> selectAllOrder();

    @Select("select * from ordere where o_id = #{o_id}")
    Ordere OrdereById(int o_id);

    @Select("select * from ordere where user_id = #{user_id} and post_status = 1")
    Collection<Ordere> OrdereUser(int user_id);

    @Select("select * from ordere where user_id = #{user_id} and pay_status = 0")
    Collection<Ordere> OrdereUserPay(int user_id);

    /*@Select("select * from ordere where user_id = #{user_id} and pay_status = 0")
    @Results({
            @Result(id=true, column = "o_id", property = "o_id"),
            @Result(column = "o_time", property = "o_time"),
            @Result(column = "shr_name", property = "shr_name"),
            @Result(column = "shr_address", property = "shr_address"),
            @Result(column = "shr_phone", property = "shr_phone"),
            @Result(column = "total_price", property = "total_price"),
            @Result(column = "pay_status", property = "pay_status"),
            @Result(column = "post_status", property = "post_status"),
            @Result(column = "user_id", property = "user_id"),
            @Result(column = "user_id", property = "user",
                    one = @One(select = "com.system.dao.OrderDao.find", fetchType = FetchType.EAGER))
    })
    Collection<Ordere> OrdereUserPay(int user_id);
    @Select("select * from medica where m_id = #{m_id}")
    User find(Integer m_id);*/

    @Update("update ordere set shr_name=#{shr_name},shr_address=#{shr_address},shr_phone=#{shr_phone} where o_id=#{o_id}")
    int updateOrder(Ordere ordere);

    @Update("update ordere set pay_status = 1 where o_id=#{o_id}")
    int updateOrderPay(Integer o_id);

    @Update("update ordere set post_status = 1 where o_id=#{o_id}")
    int updateOrderStatus(Ordere ordere);

    @Delete("delete from ordere where o_id= #{o_id}")
    int deleteOrder(int o_id);

    
}
