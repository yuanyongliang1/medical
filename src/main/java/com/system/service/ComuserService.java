package com.system.service;

import com.system.pojo.Comuser;

import java.util.List;

/**
 * @ClassName ComuserService
 * @Description TODO
 * @Author 15135
 * @Date 2020/12/8 10:34
 **/
public interface ComuserService {
    Comuser selectAllComuser(Integer u_id,Integer c_id);

    int insertComuser(Integer u_id,Integer c_id);

    int deleteComuser(Integer u_id,Integer c_id);

    List<Comuser> selectComuserById(Integer u_id);
}
