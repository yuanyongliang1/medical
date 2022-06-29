package com.system.service.Impl;


import com.system.dao.ClassificationDao;
import com.system.pojo.Classification;
import com.system.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @ClassName ClassificationServiceImpl
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/20 12:57
 **/
@Service
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    ClassificationDao classificationDao;

    @Override
    public Collection<Classification> selectAll() {
        return classificationDao.selectAll();
    }

    @Override
    public int insertcf(Classification classification) {
        return classificationDao.insertcf(classification);
    }

    @Override
    public int deletecf(int id) {
        return classificationDao.deletecf(id);
    }

    @Override
    public int updatecf(Classification classification) {
        return classificationDao.updatecf(classification);
    }

    @Override
    public int updateClassification(String c_img, int c_id) {
        return classificationDao.updateInformationimg(c_img,c_id);
    }


}
