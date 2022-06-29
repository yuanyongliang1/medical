package com.system.dao;

import com.system.pojo.Admin;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName AdminDao
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/19 8:58
 **/
@Mapper
public interface AdminDao {

    /**
     * 管理员验证登录
     * @param admin
     * @return
     */
    @Select("select * from admin where a_account = #{a_account} and a_pass = #{a_pass}")
    Admin login(Admin admin);

    /**
     * 查询所有
     *
     * @return
     */

    @Select("<script>" +
            "select * from admin " +
            "<if test='a_id > 0'> where a_id = #{a_id} </if>" +
            "</script>")
    List<Admin> getAll(Admin admin);


    /**
     * 根据id查询信息
     *
     * @param id
     * @return
     */
    @Select("select * from admin where a_id=#{a_id}")
    Admin getupid(int id);

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @Insert("insert into admin values(null,#{a_account},#{a_pass},#{a_status})")
    int insert(Admin admin);

    /**
     * 修改root数据
     *
     * @param admin
     * @return
     */
    @Update("update admin set a_account=#{a_account},a_pass=#{a_pass},a_status=#{a_status} where a_id=#{a_id}")
    int rootUpdate(Admin admin);

    /*@Update("update admin set a_status={#a_status} where a_id=#{a_id}")
    int updateStatus(String status,int id);*/


    @Update("update admin set a_status=#{a_status} where a_id=#{a_id}")
    Integer updateStatus(@Param("a_status") String a_status,
                         @Param("a_id")Integer a_id);

    /*@Select("<script>select * from registration " +
            "<if test=\"r_department !=null and r_department != ''\">" +
            "where r_department = #{r_department} </if></script>")*/


    /**
     *
     * 根据id删除root用户
     *
     * @param a_id
     * @return
     */
    @Delete("delete from admin where a_id= #{a_id}")
    int delete(int a_id);
}
