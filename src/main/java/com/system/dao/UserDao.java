package com.system.dao;

import com.system.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName AdminDao
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/19 8:58
 **/
@Mapper
public interface UserDao {

    /**
     * 管理员验证登录
     * @param user
     * @return
     */
    @Select("select * from user where u_account = #{u_account} and u_pass = #{u_pass}")
    User login(User user);

    /**
     * 查询所有
     *
     * @return
     */

    @Select("<script>" +
            "select * from user " +
            "<if test='u_id > 0'> where u_id = #{u_id} </if>" +
            "</script>")
    List<User> getAll(User user);


    /**
     * 根据id查询信息
     *
     * @param id
     * @return
     */
    @Select("select * from user where u_id=#{u_id}")
    User getupid(int id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Insert("insert into user values(null,#{u_account},#{u_pass},#{u_status}," +
            "#{u_order},#{u_stickers},#{u_collect},#{u_name},#{u_address},#{u_age})")
    int insert(User user);




    /**
     * 修改root数据
     *
     * @param user
     * @return
     */
    @Update("update user set u_account=#{u_account},u_pass=#{u_pass},u_status=#{u_status} where u_id=#{u_id}")
    int rootUpdate(User user);

    /*@Update("update admin set a_status={#a_status} where a_id=#{a_id}")
    int updateStatus(String status,int id);*/


    @Update("update admin set u_status=#{u_status} where u_id=#{u_id}")
    Integer updateStatus(@Param("a_status") String u_status,
                         @Param("a_id") Integer u_id);

    /*@Select("<script>select * from registration " +
            "<if test=\"r_department !=null and r_department != ''\">" +
            "where r_department = #{r_department} </if></script>")*/


    /**
     * 根据id删除root用户
     *
     * @param u_id
     * @return
     */
    @Delete("delete from user where u_id= #{u_id}")
    int delete(int u_id);
}
