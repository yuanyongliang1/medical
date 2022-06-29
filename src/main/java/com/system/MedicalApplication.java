package com.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@MapperScan("com.system.dao")
@SpringBootApplication
public class MedicalApplication {

    /*public static void main(String[] args) throws IOException {
        SpringApplication.run(MedicalApplication.class, args);

    }*/
    public static void main(String[] args) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
    }

}
