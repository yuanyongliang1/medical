package com.system.service;
import com.system.pojo.Medica;

import java.util.Collection;

/**
 * @ClassName MedicatypeService
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/20 15:31
 **/
public interface MedicatypeService {

    Collection<Medica> selectAllmedica();

    Collection<Medica> selectMedicaByCoId(int m_status);

    int insertmedica(Medica medicatype);

    int deletemedica(int id);

    int updatemedica(Medica medicatype);

    int updateMedicaimg(String m_img,int m_id);

    int updateMedicanum(int m_num,int goods_number,int m_id);
}
