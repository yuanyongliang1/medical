package com.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.config.CollectionToJsonUtil;
import com.system.config.CommonResult;
import com.system.pojo.Registration;
import com.system.service.RegistrationService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RegistrationController
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/21 16:42
 **/

@Controller
@CrossOrigin
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

   /* @RequestMapping("/selectAllRegistration")
    @ResponseBody
    public CommonResult selectAllRegistration(Registration registration){
        Collection<Registration> registration1 = registrationService.selectAllRegistration(registration);
        JSONArray jsonArray = CollectionToJsonUtil.jsonArray(registration1);
        return new CommonResult(0,"",1000,jsonArray);
    }*/

    @RequestMapping("/selectAllRegistration")
    @ResponseBody
    public Map<String,Object> selectAllRegistration(@RequestParam(value = "page",defaultValue = "1")Integer pn,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,Registration registration){
        PageHelper.startPage(pn,limit);
        Collection<Registration> registration1 = registrationService.selectAllRegistration(registration);
        PageInfo page = new PageInfo((List) registration1,limit);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("code",0);
        pageMap.put("msg","");
        pageMap.put("data",page.getList());
        pageMap.put("count",page.getTotal());

        return pageMap;
    }


    @RequestMapping("/insertRegistration")
    @ResponseBody
    public int insertRegistration(Registration registration){
        System.out.println(registration);
        int i = registrationService.insertRegistration(registration);
        System.out.println(i);
        return i;
    }

    @RequestMapping("/deleteRegistration")
    @ResponseBody
    public int deleteRegistration(int r_id){
        int i = registrationService.deleteRegistration(r_id);
        return i;
    }

    @RequestMapping("/updateRegistration")
    @ResponseBody
    public int updateRegistration(Registration registration){
        int i = registrationService.updateRegistration(registration);
        return i;
    }
}
