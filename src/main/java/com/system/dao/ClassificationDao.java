package com.system.dao;

import com.system.pojo.Classification;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

/**
 * @ClassName ClassificationDao
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/20 12:54
 **/
@Mapper
public interface ClassificationDao {

    /**
     * 查询药瓶分类列表
     * @return
     */
    @Select("select * from Classification")
    Collection<Classification> selectAll();

    /**
     * 添加分类
     * @param classification
     * @return
     */
    @Insert("insert into classification values (null,#{c_name})")
    int insertcf(Classification classification);

    /**
     * 删除分类
     * @param id
     * @return
     */
    @Delete("delete from classification where c_id= #{c_id}")
    int deletecf(int id);

    /**
     * 修改分类
     * @param classification
     * @return
     */
    @Update("update classification set c_name=#{c_name} where c_id=#{c_id}")
    int updatecf(Classification classification);


    @Update("update classification set c_img = #{c_img} where c_id = #{c_id}")
    int updateInformationimg(String c_img,int c_id);
}
