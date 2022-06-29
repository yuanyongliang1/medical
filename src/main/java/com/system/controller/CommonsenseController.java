package com.system.controller;

import com.system.config.CollectionToJsonUtil;
import com.system.config.CommonResult;
import com.system.pojo.Commonsense;
import com.system.pojo.Information;
import com.system.service.CommonsenseService;
import com.system.service.InformationService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName InformationController
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/22 16:52
 **/
@CrossOrigin
@Controller
public class CommonsenseController {
    @Autowired
    CommonsenseService commonsenseService;

    @RequestMapping("/selectAllCommonsense")
    @ResponseBody
    public CommonResult selectAllInformation(){
        Collection<Commonsense> information = commonsenseService.selectAllCommonsense();
        JSONArray jsonArray = CollectionToJsonUtil.jsonArray(information);
        return new CommonResult(0,"",1000,jsonArray);
    }

    @RequestMapping("/selectAllCommonsensevue")
    @ResponseBody
    public Collection selectAllInformationvue(){
        Collection<Commonsense> commonsense = commonsenseService.selectAllCommonsense();
        return commonsense;
    }

    @RequestMapping("/selectCommonsenseById")
    @ResponseBody
    public Commonsense selectCommonsenseById(Integer co_id){
        System.out.println(co_id);
        Commonsense information = commonsenseService.commonsenseById(co_id);
        System.out.println(information);
        return information;
    }

    @RequestMapping("/selectCommonsenseBycoId")
    @ResponseBody
    public Collection selectCommonsenseBycoId(Integer co_status){
        System.out.println(co_status);
        Collection<Commonsense> commonsense = commonsenseService.selectcommonsenseBycoId(co_status);
        System.out.println(commonsense);
        return commonsense;
    }

    @RequestMapping("/selectcommonsenseByCoId")
    @ResponseBody
    public Collection selectcommonsenseByCoId(Integer co_i_id){
        System.out.println(co_i_id);
        Collection<Commonsense> commonsense = commonsenseService.selectcommonsenseByCoId(co_i_id);
        System.out.println(commonsense);
        return commonsense;
    }


    @RequestMapping("/insertCommonsense")
    @ResponseBody
    public int insertSubject(Commonsense commonsense,Integer u_id){
        System.out.println(commonsense);
        System.out.println(u_id);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(new Date()));
        commonsense.setCo_time(df.format(new Date()));
        System.out.println(commonsense);
        int i = commonsenseService.insertCommonsense(commonsense);
        return i;
    }

    @RequestMapping("/insertCommonsenseandimg")
    @ResponseBody
    public int insertCommonsensesndimg(Commonsense commonsense,Integer u_id){
        System.out.println(commonsense);
        System.out.println(u_id);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(new Date()));
        commonsense.setCo_time(df.format(new Date()));
        System.out.println(commonsense);
        int i = commonsenseService.insertCommonsenseandimg(commonsense);
        return i;
    }

    @RequestMapping("/deleteCommonsense")
    @ResponseBody
    public int deleteRegistration(int co_id){
        int i = commonsenseService.deleteCommonsense(co_id);
        return i;
    }

    @RequestMapping("/updateCommonsense")
    @ResponseBody
    public int updateRegistration(Commonsense information){
        int i = commonsenseService.updateCommonsense(information);
        return i;
    }


    /**
     * 更新图片
     * @param file
     * @param request
     * @param co_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/commonsense/add")
    public Map<String,Object> addlunbo(@RequestParam("file") MultipartFile file, HttpServletRequest request, int co_id) {
        Assert.notNull(file, "上传文件不能为空");
        String fName = "D:\\testFile";
        String filename = System.currentTimeMillis()+file.getOriginalFilename();
        //确保路径存在
        File file2 = new File(fName);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String savepath = fName+"\\"+filename;
        System.out.println("轮播图保存路径:"+savepath);
        Map map = new HashMap<String,Object>();
        try {
            //保存文件到服务器
            file.transferTo(new File(savepath));
            //保存到数据库
            System.out.println(filename);
            commonsenseService.updateCommonsenseimg1("http://localhost:8081/"+filename,co_id);
            //返回json
            map.put("msg","ok");
            map.put("code",200);
        } catch (Exception e) {
            map.put("msg","error");
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }



    @ResponseBody
    @RequestMapping("/commonsenseimg")
    public Map<String,Object> commonsenseimg(@RequestParam("file") MultipartFile file) {
        Assert.notNull(file, "上传文件不能为空");
        String fName = "D:\\testFile";
        String filename = System.currentTimeMillis()+file.getOriginalFilename();
        //确保路径存在
        File file2 = new File(fName);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String savepath = fName+"\\"+filename;
        Map map = new HashMap<String,Object>();
        try {
            //保存文件到服务器
            file.transferTo(new File(savepath));
            //返回json
            map.put("msg","ok");
            map.put("code",200);
            map.put("src","http://localhost:8081/"+filename);
        } catch (Exception e) {
            map.put("msg","error");
            map.put("code",0);
            e.printStackTrace();
        }
        return map;
    }

}
