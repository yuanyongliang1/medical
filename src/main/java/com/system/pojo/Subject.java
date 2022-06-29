package com.system.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor



/** 
    * @description: 专题列表
    * @param: 
    * @return: 
    * @author 15135
    * @date: 2020/11/21 17:39
 */ 
public class Subject {

  private int s_id;
  private String s_name;
  private String s_img;

  @Override
  public String toString() {
    return "Subject{" +
            "s_id=" + s_id +
            ", s_name='" + s_name + '\'' +
            ", s_img='" + s_img + '\'' +
            '}';
  }
}
