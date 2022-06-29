package com.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.config.CollectionToJsonUtil;
import com.system.config.CommonResult;
import com.system.pojo.Admin;
import com.system.pojo.Ordere;
import com.system.service.AdminService;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/19 8:53
 **/
@CrossOrigin
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/tologin")
    @ResponseBody
    public String tologin(){
        return "ok";
    }

    /**
     * 实现管理员登录到列表
     *
     * @param admin
     * @return String
     */
    @GetMapping(value = "/login")
    @ResponseBody
    public Admin login(Admin admin) {
        Admin adm = adminService.login(admin);
        return adm;
    }

    /**
     * 管理员展示
     * @return
     */
/*    @RequestMapping(value = "/showadmin")
    @ResponseBody
    public CommonResult showAll(Admin admin){
        System.out.println(admin.getA_id());
        List<Admin> admins = adminService.getAll(admin);
        JSONArray jsonArray = CollectionToJsonUtil.jsonArray(admins);
        System.out.println(jsonArray);
        return new CommonResult(200,"",1000,jsonArray);
    }*/


    @RequestMapping("/showadmin")
    @ResponseBody
    public Map<String,Object> showAll(@RequestParam(value = "page",defaultValue = "1")Integer pn,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit,Admin admin){
        PageHelper.startPage(pn,limit);
        List<Admin> admins = adminService.getAll(admin);
        PageInfo page = new PageInfo(admins,limit);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("code",200);
        pageMap.put("msg","");
        pageMap.put("data",page.getList());
        pageMap.put("count",page.getTotal());

        return pageMap;
    }

    /**
     * 管理员的修改
     * @return
     */

  /*  @PostMapping(value = "getupdate")
    @ResponseBody
    public Admin getupdate(@RequestBody JSONObject obj){
        Iterator<String> it = obj.keys();
        String value = obj.getString(it.next());
        int i = Integer.parseInt(value);
        System.out.println(i);
        Admin admin = adminService.getupid(i);
        System.out.println(admin);
        return admin;
    }*/


  @RequestMapping(value = "getupdate")
  @ResponseBody
  public Admin getupid(int a_id){
      System.out.println(a_id);
      Admin  admin = adminService.getupid(a_id);
      return admin;
  }
    @RequestMapping("/updateadmin")
    @ResponseBody
    public int update(Admin admin){
       int i =  adminService.rootUpdate(admin);
        return i;
    }

    @PostMapping("/updatestatus")
    @ResponseBody
    public int updatestatus(@RequestParam("a_id") Integer a_id,
                            @RequestParam("a_status") String a_status){
        System.out.println(a_status);
        System.out.println(a_id);
        int i =  adminService.rootUpdate(a_status,a_id);
        return i;
    }

    /**
     * 管理员添加
     * @param admin
     * @return
     */
    @GetMapping("/insert")
    @ResponseBody
    public int insert(Admin admin){
        admin.setA_status("1");
        int i =  adminService.insert(admin);
        return i;
    }


    /**
     * 管理员的删除
     * @param a_id
     * @return
     */
    @GetMapping("/delete")
    @ResponseBody
    public int delete(Integer a_id){
        System.out.println(a_id);
        int i = adminService.rootdelete(a_id);
        System.out.println(i);
       return i;
    }
}
