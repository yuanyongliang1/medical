package com.system.service;

import com.system.pojo.Commonsense;
import com.system.pojo.Information;

import java.util.Collection;

/**
 * @ClassName InformationService
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/22 16:23
 **/
public interface CommonsenseService {

    Collection<Commonsense> selectAllCommonsense();

    Collection<Commonsense> selectcommonsenseByCoId(int co_i_id);
    Collection<Commonsense> selectcommonsenseBycoId(int co_status);

    Commonsense commonsenseById(int co_id);

    int insertCommonsense(Commonsense commonsense);

    int insertCommonsenseandimg(Commonsense commonsense);

    int deleteCommonsense(int id);

    int updateCommonsense(Commonsense commonsense);

    int updateCommonsenseimg(Commonsense commonsense);

    int updateCommonsenseimg1(String co_img, int co_id);
}
