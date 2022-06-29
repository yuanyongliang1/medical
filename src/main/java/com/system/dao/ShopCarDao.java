package com.system.dao;

import com.system.pojo.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName ShopCarDao
 * @Description TODO
 * @Author 15135
 * @Date 2020/12/3 15:47
 **/
@Mapper
public interface ShopCarDao {
    @Insert("insert into shopcar values (null,#{goods_id},1,#{user_id})")
    int insert(Shopcar shopcar);

    @Select("select * from shopcar where user_id = #{user_id}")
    Collection<Shopcar> selectAll(int user_id);


    @Select("select * from shopcar where user_id = #{user_id}")
    @Results({
            @Result(id=true, column = "sc_id", property = "sc_id"),
            @Result(column = "goods_id", property = "goods_id"),
            @Result(column = "goods_id", property = "medica",
                    one = @One(select = "com.system.dao.ShopCarDao.findmedica", fetchType = FetchType.EAGER)),

            @Result(column = "goods_number", property = "goods_number"),
            @Result(column = "user_id", property = "user_id"),
            @Result(column = "user_id", property = "user",
                    one = @One(select = "com.system.dao.ShopCarDao.finduser", fetchType = FetchType.EAGER))
    })
    List<Shopcar> selectAllShopcar1(int user_id);

    @Select("select * from medica where m_id = #{m_id}")
    Medica findmedica1(Integer m_id);

    @Select("select * from user where u_id = #{u_id}")
    User finduser1(Integer u_id);



    @Select("select * from shopcar")
    @Results({
            @Result(id=true, column = "sc_id", property = "sc_id"),
            @Result(column = "goods_id", property = "goods_id"),
            @Result(column = "goods_id", property = "medica",
                    one = @One(select = "com.system.dao.ShopCarDao.findmedica", fetchType = FetchType.EAGER)),

            @Result(column = "goods_number", property = "goods_number"),
            @Result(column = "user_id", property = "user_id"),
            @Result(column = "user_id", property = "user",
                    one = @One(select = "com.system.dao.ShopCarDao.finduser", fetchType = FetchType.EAGER))
    })
    List<Shopcar> selectAllShopcar();

    @Select("select * from medica where m_id = #{m_id}")
    Medica findmedica(Integer m_id);

    @Select("select * from user where u_id = #{u_id}")
    User finduser(Integer u_id);


    @Select("select * from shopcar where goods_id = #{goods_id} and user_id = #{user_id}")
    Shopcar yanzheng(Shopcar shopcar);

    @Update("update shopcar set goods_number=goods_number+1 where user_id=#{user_id} and  goods_id = #{goods_id}")
    int shopcarUpdate(Shopcar shopcar);


   @Update("update shopcar set goods_number=goods_number+1 where user_id=#{user_id} and  goods_id = #{goods_id}")
    int shopcarAdd(Integer user_id, Integer goods_id);

    @Update("update shopcar set goods_number=goods_number-1 where user_id=#{user_id} and  goods_id = #{goods_id}")
    int shopcarSub(Integer user_id, Integer goods_id);

    @Delete("delete from shopcar where goods_id= #{goods_id} and user_id=#{user_id}")
    int deleteShopCar(int goods_id,int user_id);

}
