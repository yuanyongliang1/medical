package com.system.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoods {

  private long order_id;
  private long goods_id;
  private double user_id;
  private double goods_price;
  private long goods_number;

  @Override
  public String toString() {
    return "OrderGoods{" +
            "order_id=" + order_id +
            ", goods_id=" + goods_id +
            ", user_id=" + user_id +
            ", goods_price=" + goods_price +
            ", goods_number=" + goods_number +
            '}';
  }
}
