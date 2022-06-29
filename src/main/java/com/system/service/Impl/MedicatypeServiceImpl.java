package com.system.service.Impl;

import com.system.dao.MedicatypeDao;
import com.system.pojo.Medica;
import com.system.service.MedicatypeService;
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
public class MedicatypeServiceImpl implements MedicatypeService {

    @Autowired
    MedicatypeDao medicatypeDao;

    @Override
    public Collection<Medica> selectAllmedica() {
        return medicatypeDao.selectAllmedica();
    }

    @Override
    public Collection<Medica> selectMedicaByCoId(int m_status) {
        return medicatypeDao.selectMedicaByCoId(m_status);
    }

    @Override
    public int insertmedica(Medica medicatype) {
        return medicatypeDao.insertmedica(medicatype);
    }

    @Override
    public int deletemedica(int id) {
        return medicatypeDao.deletemedica(id);
    }

    @Override
    public int updatemedica(Medica medicatype) {
        return medicatypeDao.updatemedica(medicatype);
    }

    @Override
    public int updateMedicaimg(String m_img, int m_id) {
        return medicatypeDao.updateMedicaimg(m_img,m_id);
    }

    @Override
    public int updateMedicanum(int m_num ,int goods_number, int m_id) {
        return medicatypeDao.updateMedicanum(m_num,goods_number,m_id);
    }

}
