package com.system.service;

import com.system.dao.InformationDao;
import com.system.pojo.Information;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * @ClassName InformationService
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/22 16:23
 **/
public interface InformationService {

    Collection<Information> selectAllInformation();

    int insertInformation(Information information);

    int deleteInformation(int id);

    int updateInformation(Information information);

    int updateInformationimg(Information information);

    int updateInformationimg1(String i_img,int i_id);
}
