package com.system.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shopcar {

  private long sc_id;
  private long goods_id;
  private long goods_number;
  private long user_id;
  private User user;
  private Medica medica;

  @Override
  public String toString() {
    return "Shopcar{" +
            "sc_id=" + sc_id +
            ", goods_id=" + goods_id +
            ", goods_number=" + goods_number +
            ", user_id=" + user_id +
            ", user=" + user +
            ", medica=" + medica +
            '}';
  }
}
