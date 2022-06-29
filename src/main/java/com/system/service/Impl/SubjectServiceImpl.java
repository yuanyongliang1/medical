package com.system.service.Impl;

import com.system.dao.SubjectDao;
import com.system.pojo.Registration;
import com.system.pojo.Subject;
import com.system.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @ClassName SubjectServiceImpl
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/21 17:36
 **/
@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    SubjectDao subjectDao;


    @Override
    public Collection<Subject> selectAllSubject() {
        return subjectDao.subjectAll();
    }

    @Override
    public int insertSubject(Subject Subject) {
        return subjectDao.insertSubject(Subject);
    }

    @Override
    public int deleteSubject(int id) {
        return subjectDao.deleteSubject(id);
    }

    @Override
    public int updateSubject(Subject Subject) {
        return subjectDao.updateSubject(Subject);
    }

    @Override
    public int updateSubjectimg(Subject subject) {
        return subjectDao.updateSubject(subject);
    }

    @Override
    public int updateSubjectimg1(String s_img, int s_id) {
        return subjectDao.updateSubjectimg1(s_img,s_id);
    }
}
