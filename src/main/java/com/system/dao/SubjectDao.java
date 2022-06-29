package com.system.dao;

import com.system.pojo.Subject;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

/**
 * @ClassName SubjectDao
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/21 17:31
 **/
@Mapper
public interface SubjectDao {
 /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from subject")
    Collection<Subject> subjectAll();



    /**
     * 添加管理员
     * @param subject
     * @return
     */
    @Insert("insert into subject values(null,#{s_name},null)")
    int insertSubject(Subject subject);

  /* @Insert("insert into subject values(null,null,#{s_img})")*/
  /* @Update("update subject set s_name=#{s_name},s_img=#{s_img} where s_id=#{s_id}")
    int updateSubjectimg(Subject subject);*/



    /**
     * 修改root数据
     *
     * @param subject
     * @return
     */
    @Update("update subject set s_name=#{s_name},s_img=#{s_img} where s_id=#{s_id}")
    int updateSubject(Subject subject);


    /**
     * 根据id删除root用户
     *
     * @param s_id
     * @return
     */
    @Delete("delete from subject where s_id= #{s_id}")
    int deleteSubject(int s_id);

    @Update("update subject set s_img = #{s_img} where s_id = #{s_id}")
    int updateSubjectimg1(String s_img,int s_id);
}
