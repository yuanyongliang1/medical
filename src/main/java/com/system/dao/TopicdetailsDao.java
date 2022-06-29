package com.system.dao;

import com.system.pojo.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName TopicdetailsDao
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/25 8:24
 **/
@Mapper
public interface TopicdetailsDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from topicdetails")
    @Results({
            @Result(id=true, column = "t_id", property = "t_id"),
            @Result(column = "t_details", property = "t_details"),
            @Result(column = "t_yes", property = "t_yes"),
            @Result(column = "t_s_id", property = "t_s_id"),
            @Result(column = "t_s_id", property = "subject", one = @One(select = "com.system.dao.TopicdetailsDao.findType", fetchType = FetchType.EAGER))
    })
    public List<Topicdetails> selectAllTopicdetails();

    @Select("select * from subject where s_id = #{s_id}")
    public Subject findType(Integer id);

    @Select("select * from topicdetails where t_id = #{t_id}")
    Topicdetails topicdetailsById(int t_id);


    @Select("select * from topicdetails where t_s_id = #{t_s_id}")
    Collection<Topicdetails> selectTopicdetailsByCoId(int t_s_id);
    /**
     * 添加分类
     * @param topicdetails
     * @return
     */
    @Insert("insert into topicdetails values (null,#{t_details},0,#{t_s_id})")
    int insertTopicdetails(Topicdetails topicdetails);

    /**
     * 删除分类
     * @param id
     * @return
     */
    @Delete("delete from topicdetails where t_id= #{t_id}")
    int deleteTopicdetails(int id);

    /**
     * 修改分类
     * @param topicdetails
     * @return
     */
    @Update("update topicdetails set t_details=#{t_details},t_s_id=#{t_s_id} where t_id=#{t_id}")
    int updateTopicdetails(Topicdetails topicdetails);
}
