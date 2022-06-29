package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/** 
    * @description: 药品类型列表
    * @param: 
    * @return: 
    * @author 15135
    * @date: 2020/11/21 16:28
 */ 
public class Classification {

  private long c_id;
  private String c_name;
  private String c_img;

  @Override
  public String toString() {
    return "Classification{" +
            "c_id=" + c_id +
            ", c_name='" + c_name + '\'' +
            ", c_img='" + c_img + '\'' +
            '}';
  }
}
