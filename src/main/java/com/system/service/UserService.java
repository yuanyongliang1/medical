package com.system.service;

import com.system.pojo.Admin;
import com.system.pojo.User;

import java.util.List;

/**
 * @ClassName AdminService
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/19 8:57
 **/
public interface UserService {

    /**
     * login
     * @param user
     * @return
     */
    User loginUser(User user);
    /**
     * 查询全部
     *
     * @param
     * @return List
     */
    List<User> getAllUser(User user);


    /**
     * 进入修改页面，并展示要修改的数据，是查询
     *
     * @param id
     * @return Root
     */
    User getupidUser(int id);

    /**
     * 添加管理员
     * @param user
     * @return
     */
    int insertUser(User user);



    /**
     * 修改数据
     *
     * @param user
     * @return int
     */
    int rootUpdateUser(User user);

    int rootUpdateUser(String status, int id);

    /**
     * 删除数据
     *
     * @param u_id
     * @return
     */
    int rootdeleteUser(int u_id);

}
