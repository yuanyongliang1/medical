package com.system.service.Impl;

import com.system.dao.CommonsenseDao;
import com.system.pojo.Commonsense;
import com.system.service.CommonsenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @ClassName CommonsenseServiceImpl
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/22 18:40
 **/
@Service
public class CommonsenseServiceImpl implements CommonsenseService {
    @Autowired
    CommonsenseDao commonsenseDao;

    @Override
    public Collection<Commonsense> selectAllCommonsense() {
        return commonsenseDao.selectAllCommonsense();
    }

    @Override
    public Collection<Commonsense> selectcommonsenseByCoId(int co_i_id) {
        return commonsenseDao.selectcommonsenseByCoId(co_i_id);
    }

    @Override
    public Collection<Commonsense> selectcommonsenseBycoId(int co_status) {
        return commonsenseDao.selectcommonsenseBycoId(co_status);
    }

    @Override
    public Commonsense commonsenseById(int co_id) {
        return commonsenseDao.commonsenseById(co_id);
    }

    @Override
    public int insertCommonsense(Commonsense commonsense) {
        return commonsenseDao.insertCommonsense(commonsense);
    }

    @Override
    public int insertCommonsenseandimg(Commonsense commonsense) {
        return commonsenseDao.insertCommonsenseandimg(commonsense);
    }


    @Override
    public int deleteCommonsense(int id) {
        return commonsenseDao.deleteCommonsense(id);
    }

    @Override
    public int updateCommonsense(Commonsense commonsense) {
        return commonsenseDao.updateCommonsense(commonsense);
    }

    @Override
    public int updateCommonsenseimg(Commonsense commonsense) {
        return commonsenseDao.updateCommonsense(commonsense);
    }

    @Override
    public int updateCommonsenseimg1(String co_img, int co_id) {
        return commonsenseDao.updateCommonsenseimg1(co_img,co_id);
    }
}
