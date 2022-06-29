package com.system.service;

import com.system.dao.SubjectDao;
import com.system.pojo.Registration;
import com.system.pojo.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * @ClassName SubjectService
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/21 17:35
 **/
public interface SubjectService {

    Collection<Subject> selectAllSubject();

    int insertSubject(Subject Subject);

    int deleteSubject(int id);

    int updateSubject(Subject Subject);

    int updateSubjectimg(Subject subject);

    int updateSubjectimg1(String s_img,int s_id);
}
