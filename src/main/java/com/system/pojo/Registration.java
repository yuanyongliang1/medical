package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Registration{

  private long r_id;
  private String r_name;
  private String r_phone;
  private long r_age;
  private String r_department;
  private String r_symptoms;

  @Override
  public String toString() {
    return "Registration{" +
            "r_id=" + r_id +
            ", r_name='" + r_name + '\'' +
            ", r_phone='" + r_phone + '\'' +
            ", r_age=" + r_age +
            ", r_department='" + r_department + '\'' +
            ", r_symptoms='" + r_symptoms + '\'' +
            '}';
  }
}
