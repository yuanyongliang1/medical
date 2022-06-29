package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Topicdetails
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/25 8:22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topicdetails {
    private int t_id;
    private String t_details;
    private int t_yes;
    private int t_s_id;
    private Subject subject;

    @Override
    public String toString() {
        return "Topicdetails{" +
                "t_id=" + t_id +
                ", t_details='" + t_details + '\'' +
                ", t_yes=" + t_yes +
                ", t_s_id=" + t_s_id +
                ", subject=" + subject +
                '}';
    }
}
