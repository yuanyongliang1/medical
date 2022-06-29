package com.system.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordere {

  private long o_id;
  private String o_time;
  private String shr_name;
  private String shr_address;
  private String shr_phone;
  private double total_price;
  private String pay_status;
  private String post_status;
  private int user_id;
  private Medica medica;

  @Override
  public String toString() {
    return "Ordere{" +
            "o_id=" + o_id +
            ", o_time='" + o_time + '\'' +
            ", shr_name='" + shr_name + '\'' +
            ", shr_address='" + shr_address + '\'' +
            ", shr_phone='" + shr_phone + '\'' +
            ", total_price=" + total_price +
            ", pay_status='" + pay_status + '\'' +
            ", post_status='" + post_status + '\'' +
            ", user_id=" + user_id +
            ", medica=" + medica +
            '}';
  }
}
