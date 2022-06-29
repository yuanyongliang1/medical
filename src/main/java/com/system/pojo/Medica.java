package com.system.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medica{

  private long m_id;
  private String m_name;
  private double m_maney;
  private String m_details;
  private long m_status;
  private String m_img;
  private int m_num;
  private int m_count;
  private Classification classification;

  @Override
  public String toString() {
    return "Medica{" +
            "m_id=" + m_id +
            ", m_name='" + m_name + '\'' +
            ", m_maney=" + m_maney +
            ", m_details='" + m_details + '\'' +
            ", m_status=" + m_status +
            ", m_img='" + m_img + '\'' +
            ", m_num=" + m_num +
            ", m_count=" + m_count +
            ", classification=" + classification +
            '}';
  }
}
