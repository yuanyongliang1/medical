package com.system.service.Impl;

import com.system.dao.RegistrationDao;
import com.system.pojo.Registration;
import com.system.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @ClassName RegistrationServiceImpl
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/21 16:38
 **/
@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    RegistrationDao registrationDao;

    @Override
    public Collection<Registration> selectAllRegistration(Registration registration) {
        return registrationDao.selectAllRegistration(registration);
    }

    @Override
    public int insertRegistration(Registration registration) {
        return registrationDao.insertRegistration(registration);
    }

    @Override
    public int deleteRegistration(int id) {
        return registrationDao.deleteRegistration(id);
    }

    @Override
    public int updateRegistration(Registration registration) {
        return registrationDao.updateRegistration(registration);
    }
}
