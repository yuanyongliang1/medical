package com.system.service.Impl;

import com.system.dao.AdminDao;
import com.system.dao.UserDao;
import com.system.pojo.Admin;
import com.system.pojo.User;
import com.system.service.AdminService;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/19 8:57
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    @Override
    public User loginUser(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> getAllUser(User user) {
        return userDao.getAll(user);
    }

    @Override
    public User getupidUser(int id) {
        return userDao.getupid(id);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public int rootUpdateUser(User user) {
        return userDao.rootUpdate(user);
    }

    @Override
    public int rootUpdateUser(String status, int id) {
        return userDao.updateStatus(status,id);
    }

    @Override
    public int rootdeleteUser(int u_id) {
        return userDao.delete(u_id);
    }
}
