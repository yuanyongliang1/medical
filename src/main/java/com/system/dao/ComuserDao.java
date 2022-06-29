package com.system.dao;

import com.system.pojo.Commonsense;
import com.system.pojo.Comuser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ComuserDao
 * @Description TODO
 * @Author 15135
 * @Date 2020/12/8 10:23
 **/
@Repository
public interface ComuserDao {

   @Select("select * from comuser where u_id = #{u_id} and c_id = #{c_id}")
   Comuser selectAllComuser(Integer u_id,Integer c_id);

   @Insert("insert into comuser values(null,#{u_id},#{c_id})")
   int insertComuser(Integer u_id,Integer c_id);

   @Delete("delete from comuser where u_id= #{u_id} and c_id = #{c_id}")
   int deleteComuser(Integer u_id,Integer c_id);

    @Select("select * from Comuser where u_id = #{u_id}")
    @Results({
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "u_id", property = "u_id"),
            @Result(column = "c_id", property = "c_id"),
            @Result(column = "c_id", property = "commonsense",
                    one = @One(select = "com.system.dao.ComuserDao.find", fetchType = FetchType.EAGER))
    })
    List<Comuser> selectComuserById(Integer u_id);
    @Select("select * from commonsense where co_id = #{co_id}")
    Commonsense find(Integer id);
}
