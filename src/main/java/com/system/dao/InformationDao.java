package com.system.dao;

import com.system.pojo.Information;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

/**
 * @ClassName InformationDao
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/22 16:11
 **/
@Mapper
public interface InformationDao {
    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from information")
    Collection<Information> informationtAll();



    /**
     * 添加管理员
     * @param information
     * @return
     */
    @Insert("insert into information values(null,#{i_name},null)")
    int insertInformation(Information information);

    /**
     * 修改root数据
     *
     * @param information
     * @return
     */
    @Update("update information set i_name=#{i_name} where i_id=#{i_id}")
    int updateInformation(Information information);


    /**
     * 根据id删除root用户
     *
     * @param i_id
     * @return
     */
    @Delete("delete from information where i_id= #{i_id}")
    int deleteInformation(int i_id);

    @Update("update information set i_img = #{i_img} where i_id = #{i_id}")
    int updateInformationimg1(String i_img,int i_id);
}
