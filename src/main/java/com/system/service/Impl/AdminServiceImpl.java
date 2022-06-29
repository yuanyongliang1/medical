package com.system.service.Impl;

import com.system.dao.AdminDao;
import com.system.pojo.Admin;
import com.system.service.AdminService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/19 8:57
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }

    @Override
    public List<Admin> getAll(Admin admin) {
        List<Admin> admins = adminDao.getAll(admin);
        return admins;
    }


    @Override
    public Admin getupid(int id) {
        return adminDao.getupid(id);
    }

    @Override
    public int insert(Admin admin) {
        return adminDao.insert(admin);

    }

    @Override
    public int rootUpdate(Admin admin) {
        return adminDao.rootUpdate(admin);
    }

    @Override
    public int rootUpdate(String status, int id) {
        return adminDao.updateStatus(status,id);
    }

    @Override
    public int rootdelete(int a_id) {
        return adminDao.delete(a_id);
    }

}
