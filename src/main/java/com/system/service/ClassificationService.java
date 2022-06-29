package com.system.service;

import com.system.pojo.Classification;

import java.util.Collection;

/**
 * @ClassName ClassificationService
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/20 12:56
 **/
public interface ClassificationService {

    Collection<Classification> selectAll();

    int insertcf(Classification classification);

    int deletecf(int id);

    int updatecf(Classification classification);

    int updateClassification(String c_img,int c_id);
}
