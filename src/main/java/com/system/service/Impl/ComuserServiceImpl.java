package com.system.service.Impl;

import com.system.dao.ComuserDao;
import com.system.pojo.Comuser;
import com.system.service.ComuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ComuserServiceImpl
 * @Description TODO
 * @Author 15135
 * @Date 2020/12/8 10:35
 **/
@Service
public class ComuserServiceImpl implements ComuserService {

    @Autowired
    private ComuserDao comuserDao;

    @Override
    public Comuser selectAllComuser(Integer u_id, Integer c_id) {
        return comuserDao.selectAllComuser(u_id,c_id);
    }

    @Override
    public int insertComuser(Integer u_id, Integer c_id) {
        return comuserDao.insertComuser(u_id,c_id);
    }

    @Override
    public int deleteComuser(Integer u_id, Integer c_id) {
        return comuserDao.deleteComuser(u_id,c_id);
    }

    @Override
    public List<Comuser> selectComuserById(Integer u_id) {
        return comuserDao.selectComuserById(u_id);
    }


}
