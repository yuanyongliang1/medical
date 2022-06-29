package com.system.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/** 
    * @description: 管理员列表
    * @param: 
    * @return: 
    * @author 15135
    * @date: 2020/11/21 16:28
 */ 
public class Admin {

  private long a_id;
  private String a_account;
  private String a_pass;
  private String a_status;



  @Override
  public String toString() {
    return "Admin{" +
            "a_id=" + a_id +
            ", a_account='" + a_account + '\'' +
            ", a_pass='" + a_pass + '\'' +
            ", a_status='" + a_status + '\'' +
            '}';
  }
}
