package com.system.service.Impl;

import com.system.dao.InformationDao;
import com.system.pojo.Information;
import com.system.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @ClassName InformationServiceImpl
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/22 16:38
 **/
@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    InformationDao informationDao;


    @Override
    public Collection<Information> selectAllInformation() {
        return informationDao.informationtAll();
    }

    @Override
    public int insertInformation(Information information) {
        return informationDao.insertInformation(information);
    }

    @Override
    public int deleteInformation(int id) {
        return informationDao.deleteInformation(id);
    }

    @Override
    public int updateInformation(Information information) {
        return informationDao.updateInformation(information);
    }

    @Override
    public int updateInformationimg(Information information) {
        return 0;
    }


    @Override
    public int updateInformationimg1(String i_img, int i_id) {
        return informationDao.updateInformationimg1(i_img,i_id);
    }
}
