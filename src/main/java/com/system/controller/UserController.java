package com.system.controller;

import com.system.config.CollectionToJsonUtil;
import com.system.config.CommonResult;
import com.system.pojo.User;
import com.system.service.UserService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/19 8:53
 **/
@CrossOrigin
@Controller
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 实现用户登录到列表
     *
     * @param user
     * @return String
     */
    @GetMapping(value = "/loginUser")
    @ResponseBody
    public User login(User user) {
        User adm = userService.loginUser(user);
        System.out.println(adm);
        return adm;
    }

    /**
     * 用户展示
     * @return
     */
    @RequestMapping(value = "/showUser")
    @ResponseBody
    public CommonResult showAll(User user){
        List<User> users = userService.getAllUser(user);
        JSONArray jsonArray = CollectionToJsonUtil.jsonArray(users);
        return new CommonResult(200,"",1000,jsonArray);
    }

    @RequestMapping(value = "/showUserAll")
    @ResponseBody
    public List showUserAll(User user){
        List<User> users = userService.getAllUser(user);

        return users;
    }


  @RequestMapping(value = "getupdateUser")
  @ResponseBody
  public User getupid(int u_id){
      User  admin = userService.getupidUser(u_id);
      return admin;
  }
    @RequestMapping("/updateUser")
    @ResponseBody
    public int update(User admin){
       int i =  userService.rootUpdateUser(admin);
        return i;
    }

    @PostMapping("/updatestatusUser")
    @ResponseBody
    public int updatestatus(@RequestParam("u_id") Integer u_id,
                            @RequestParam("u_status") String u_status){
        System.out.println(u_status);
        System.out.println(u_id);
        int i =  userService.rootUpdateUser(u_status,u_id);
        return i;
    }

    /**
     * 用户添加
     * @param user
     * @return
     */
    @GetMapping("/insertUser")
    @ResponseBody
    public int insert(User user){
        user.setU_status("1");
        System.out.println(user);
        User adm = userService.loginUser(user);
        if(adm == null){
            int i =  userService.insertUser(user);
            System.out.println(i);
            return i;
        }
            return 0;
    }


    /**
     * 用户的删除
     * @param u_id
     * @return
     */
    @GetMapping("/deleteUser")
    @ResponseBody
    public int delete(Integer u_id){
        int i = userService.rootdeleteUser(u_id);
       return i;
    }
}
