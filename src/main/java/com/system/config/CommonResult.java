package com.system.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Insert;

/**
 * @ClassName CommonResult
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/20 16:31
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {
    private Integer code;
    private String msg;
    private Integer count;
    private Object data;
}
