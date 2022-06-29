package com.system.pojo;

import lombok.*;
/**
 * @ClassName Comuser
 * @Description TODO
 * @Author 15135
 * @Date 2020/12/8 10:21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comuser {
    private Integer id;
    private Integer u_id;
    private Integer c_id;
    private Commonsense commonsense;

    @Override
    public String toString() {
        return "Comuser{" +
                "id=" + id +
                ", u_id=" + u_id +
                ", c_id=" + c_id +
                '}';
    }
}
