package com.system.dao;

import com.system.pojo.Classification;
import com.system.pojo.Commonsense;
import com.system.pojo.Medica;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName MedicatypeDao
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/20 15:30
 **/

@Repository
public interface MedicatypeDao {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from medica")
    @Results({
            @Result(id=true, column = "m_id", property = "m_id"),
            @Result(column = "m_name", property = "m_name"),
            @Result(column = "m_maney", property = "m_maney"),
            @Result(column = "m_details", property = "m_details"),
            @Result(column = "m_img", property = "m_img"),
            @Result(column = "m_count", property = "m_count"),
            @Result(column = "m_status", property = "m_status"),
            @Result(column = "m_status", property = "classification", one = @One(select = "com.system.dao.MedicatypeDao.findType", fetchType = FetchType.EAGER))
    })
    public List<Medica> selectAllmedica();

    @Select("select * from classification where c_id = #{c_id}")
    public Classification findType(Integer id);

    /**
     * 添加分类
     * @param medicatype
     * @return
     */
    @Insert("insert into medica values (null,#{m_name},#{m_maney},#{m_details},#{m_status},1)")
    int     insertmedica(Medica medicatype);

    @Select("select * from medica where m_status = #{m_status}")
    Collection<Medica> selectMedicaByCoId(int m_status);

    /**
     * 删除分类
     * @param id
     * @return
     */
    @Delete("delete from medica where m_id= #{m_id}")
    int deletemedica(int id);

    /**
     * 修改分类
     * @param medicatype
     * @return
     */
    @Update("update medica set m_name=#{m_name},m_maney=#{m_maney},m_details=#{m_details},m_status=#{m_status} where m_id=#{m_id}")
    int updatemedica(Medica medicatype);

    @Update("update medica set m_img = #{m_img} where m_id = #{m_id}")
    int updateMedicaimg(String m_img,int m_id);

    @Update("update medica set m_num = #{m_num}-#{goods_number} where m_id = #{m_id}")
    int updateMedicanum(int m_num,int goods_number,int m_id);
}
