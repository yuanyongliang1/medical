package com.system.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commonsense {

  private int co_id;
  private String co_details;
  private int co_yes;
  private int co_retweets;
  private String co_img;
  private int co_i_id;
  private String co_time;
  private Integer co_status;
  private Information information;

  @Override
  public String toString() {
    return "Commonsense{" +
            "co_id=" + co_id +
            ", co_details='" + co_details + '\'' +
            ", co_yes=" + co_yes +
            ", co_retweets=" + co_retweets +
            ", co_img='" + co_img + '\'' +
            ", co_i_id=" + co_i_id +
            ", co_time='" + co_time + '\'' +
            ", co_status=" + co_status +
            ", information=" + information +
            '}';
  }
}
