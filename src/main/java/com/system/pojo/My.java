package com.system.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class My {

  private long my_id;
  private String my_shop;
  private String my_stickers;
  private String my_collect;
  private String my_name;
  private long my_age;
  private String my_address;

  @Override
  public String toString() {
    return "My{" +
            "my_id=" + my_id +
            ", my_shop='" + my_shop + '\'' +
            ", my_stickers='" + my_stickers + '\'' +
            ", my_collect='" + my_collect + '\'' +
            ", my_name='" + my_name + '\'' +
            ", my_age=" + my_age +
            ", my_address='" + my_address + '\'' +
            '}';
  }
}
