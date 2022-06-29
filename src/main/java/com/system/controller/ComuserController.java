package com.system.controller;

import com.system.config.CollectionToJsonUtil;
import com.system.config.CommonResult;
import com.system.pojo.Commonsense;
import com.system.pojo.Comuser;
import com.system.service.ComuserService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName ComuserController
 * @Description TODO
 * @Author 15135
 * @Date 2020/12/8 10:36
 **/
@CrossOrigin
@Controller
public class ComuserController {
    @Autowired
    private ComuserService comuserServices;

    @RequestMapping("/selectAllComuser")
    @ResponseBody
    public Comuser selectAllComuser(Integer u_id, Integer c_id){
        Comuser comusers = comuserServices.selectAllComuser(u_id,c_id);
        System.out.println(comusers);
       return comusers;
    }

    @RequestMapping("/insertComuser")
    @ResponseBody
    public int insertComuser(Integer u_id, Integer c_id){
        System.out.println(u_id);
        System.out.println(c_id);
        int i = comuserServices.insertComuser(u_id,c_id);
        System.out.println(i);
        return i;
    }

    @RequestMapping("/deleteComuser")
    @ResponseBody
    public int deleteComuser(Integer u_id, Integer c_id){
        int i = comuserServices.deleteComuser(u_id,c_id);
        return i;
    }

    @RequestMapping("/selectComuserById")
    @ResponseBody
    public List selectComuserById(Integer u_id){
        List<Comuser> comusers = comuserServices.selectComuserById(u_id);
        System.out.println(comusers);
        return comusers;
    }
}
