package com.system.dao;

import com.system.pojo.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName InformationDao
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/22 16:11
 **/
@Repository
public interface CommonsenseDao {
    /**
     * 查询所有
     *
     * @return
     */
    /*@Select("select * from commonsense")
    Collection<Commonsense> commonsenseAll();*/
    @Select("select * from commonsense")
    @Results({
            @Result(id=true, column = "co_id", property = "co_id"),
            @Result(column = "co_details", property = "co_details"),
            @Result(column = "co_yes", property = "co_yes"),
            @Result(column = "co_retweets", property = "co_retweets"),
            @Result(column = "co_img", property = "co_img"),
            @Result(column = "co_status", property = "co_status"),
            @Result(column = "co_i_id", property = "co_i_id"),
            @Result(column = "co_i_id", property = "information", one = @One(select = "com.system.dao.CommonsenseDao.find", fetchType = FetchType.EAGER))
    })
    public List<Commonsense> selectAllCommonsense();
    @Select("select * from information where i_id = #{i_id}")
    public Information find(Integer id);


    @Select("select * from commonsense where co_id=#{co_id}")
    @Results({
            @Result(id=true, column = "co_id", property = "co_id"),
            @Result(column = "co_details", property = "co_details"),
            @Result(column = "co_yes", property = "co_yes"),
            @Result(column = "co_retweets", property = "co_retweets"),
            @Result(column = "co_img", property = "co_img"),
            @Result(column = "co_status", property = "co_status"),
            @Result(column = "co_i_id", property = "co_i_id"),
            @Result(column = "co_i_id", property = "information", one = @One(select = "com.system.dao.CommonsenseDao.findById", fetchType = FetchType.EAGER))
    })
    Commonsense commonsenseById(int co_id);
    @Select("select * from information where i_id = #{i_id}")
    public Information findById(Integer id);
   /* @Select("select * from commonsense where co_id = #{co_id}")
    Commonsense commonsenseById(int co_id);*/

    @Select("select * from commonsense where co_i_id = #{co_i_id}")
    Collection<Commonsense> selectcommonsenseByCoId(int co_i_id);


    @Select("select * from commonsense where co_status = #{co_status}")
    Collection<Commonsense> selectcommonsenseBycoId(int co_status);


    @Insert("insert into commonsense values(null,#{co_details},0,0,null,#{co_i_id},#{co_time},#{co_status})")
    int insertCommonsense(Commonsense commonsense);


    @Insert("insert into commonsense values(null,#{co_details},0,0,#{co_img},#{co_i_id},#{co_time},#{co_status})")
    int insertCommonsenseandimg(Commonsense commonsense);


    @Update("update commonsense set co_details=#{co_details} where co_id=#{co_id}")
    int updateCommonsense(Commonsense commonsense);



    @Delete("delete from commonsense where co_id= #{co_id}")
    int deleteCommonsense(int co_id);

    @Update("update commonsense set co_img = #{co_img} where co_id = #{co_id}")
    int updateCommonsenseimg1(String co_img, int co_id);
}
