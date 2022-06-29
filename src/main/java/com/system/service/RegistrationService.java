package com.system.service;


import com.system.pojo.Registration;

import java.util.Collection;

/**
 * @ClassName RegistrationService
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/21 16:37
 **/
public interface RegistrationService {

    Collection<Registration> selectAllRegistration(Registration registration);

    int insertRegistration(Registration registration);

    int deleteRegistration(int id);

    int updateRegistration(Registration registration);


}
