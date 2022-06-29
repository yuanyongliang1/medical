package com.system.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Information {

  private long i_id;
  private String i_name;
  private String i_img;

  @Override
  public String toString() {
    return "Information{" +
            "i_id=" + i_id +
            ", i_name='" + i_name + '\'' +
            ", i_img='" + i_img + '\'' +
            '}';
  }
}
