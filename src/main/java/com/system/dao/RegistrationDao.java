package com.system.dao;


import com.system.pojo.Registration;
import org.apache.ibatis.annotations.*;

import java.util.Collection;


/**
 * @ClassName RegistrationDao
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/21 16:32
 **/
@Mapper
public interface RegistrationDao {
    /**
     * 查询所有
     * @return
     */
   @Select("<script>" +
           "select * from registration " +
           "<if test=\"r_department !=null and r_department != ''\">" +
           "where r_department = #{r_department} " +
           "</if>" +
           "</script>")
    Collection<Registration> selectAllRegistration(Registration registration);


    /**
     * 添加分类
     * @param registration
     * @return
     */
    @Insert("insert into registration values (null,#{r_name},#{r_phone},#{r_age},#{r_department},#{r_symptoms})")
    int insertRegistration(Registration registration);

    /**
     * 删除分类
     * @param id
     * @return
     */
    @Delete("delete from registration where r_id= #{r_id}")
    int deleteRegistration(int id);

    /**
     * 修改分类
     * @param registration
     * @return
     */
    @Update("update registration set r_name=#{r_name},r_phone=#{r_phone},r_age=#{r_age},r_department=#{r_department},r_symptoms=#{r_symptoms} where r_id=#{r_id}")
    int updateRegistration(Registration registration);
}
