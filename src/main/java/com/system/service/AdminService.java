package com.system.service;

import com.system.pojo.Admin;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName AdminService
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/19 8:57
 **/
public interface AdminService {

    /**
     * login
     * @param admin
     * @return
     */
    Admin login(Admin admin);
    /**
     * 查询全部
     *
     * @param
     * @return List
     */
    List<Admin> getAll(Admin admin);


    /**
     * 进入修改页面，并展示要修改的数据，是查询
     *
     * @param id
     * @return Root
     */
    Admin getupid(int id);

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    int insert(Admin admin);



    /**
     * 修改数据
     *
     * @param admin
     * @return int
     */
    int rootUpdate(Admin admin);

    int rootUpdate(String status,int id);

    /**
     * 删除数据
     *
     * @param a_id
     * @return
     */
    int rootdelete(int a_id);

}
