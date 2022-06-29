package com.system.service;

import com.system.pojo.Commonsense;
import com.system.pojo.Topicdetails;

import java.util.Collection;

/**
 * @ClassName TopicdetailsService
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/25 8:29
 **/
public interface TopicdetailsService {
    Collection<Topicdetails> selectAllTopicdetails();

    Collection<Topicdetails> selectTopicdetailsByCoId(int t_s_id);

    Topicdetails topicdetailsById(int t_id);

    int insertTopicdetails(Topicdetails topicdetails);

    int deleteTopicdetails(int id);

    int updateTopicdetails(Topicdetails topicdetails);
}