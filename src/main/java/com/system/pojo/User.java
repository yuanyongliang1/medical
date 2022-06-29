package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private long u_id;
  private String u_account;
  private String u_pass;
  private String u_status;
  private String u_order;
  private String u_stickers;
  private String u_collect;
  private String u_name;
  private String u_address;
  private Integer u_age;

  @Override
  public String toString() {
    return "User{" +
            "u_id=" + u_id +
            ", u_account='" + u_account + '\'' +
            ", u_pass='" + u_pass + '\'' +
            ", u_status='" + u_status + '\'' +
            ", u_order='" + u_order + '\'' +
            ", u_stickers='" + u_stickers + '\'' +
            ", u_collect='" + u_collect + '\'' +
            ", u_name='" + u_name + '\'' +
            ", u_address='" + u_address + '\'' +
            ", u_age=" + u_age +
            '}';
  }
}
