package com.system.service.Impl;

import com.system.dao.MedicatypeDao;
import com.system.dao.TopicdetailsDao;
import com.system.pojo.Medica;
import com.system.pojo.Topicdetails;
import com.system.service.MedicatypeService;
import com.system.service.TopicdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @ClassName MedicatypeServiceImpl
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/20 15:31
 **/
@Service
public class TopicdetailsServiceImpl implements TopicdetailsService {

    @Autowired
    TopicdetailsDao topicdetailsDao;


    @Override
    public Collection<Topicdetails> selectAllTopicdetails() {
        return topicdetailsDao.selectAllTopicdetails();
    }

    @Override
    public Collection<Topicdetails> selectTopicdetailsByCoId(int t_s_id) {
        return topicdetailsDao.selectTopicdetailsByCoId(t_s_id);
    }

    @Override
    public Topicdetails topicdetailsById(int t_id) {
        return topicdetailsDao.topicdetailsById(t_id);
    }

    @Override
    public int insertTopicdetails(Topicdetails topicdetails) {
        return topicdetailsDao.insertTopicdetails(topicdetails);
    }

    @Override
    public int deleteTopicdetails(int id) {
        return topicdetailsDao.deleteTopicdetails(id);
    }

    @Override
    public int updateTopicdetails(Topicdetails topicdetails) {
        return topicdetailsDao.updateTopicdetails(topicdetails);
    }
}
