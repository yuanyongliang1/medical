package com.system.controller;

import com.system.config.CollectionToJsonUtil;
import com.system.config.CommonResult;
import com.system.pojo.Information;
import com.system.service.InformationService;
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
import java.util.Collection;
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
public class InformationController {
    @Autowired
    InformationService informationService;

    @RequestMapping("/selectAllInformation")
    @ResponseBody
    public CommonResult selectAllInformation(){
        Collection<Information> information = informationService.selectAllInformation();
        JSONArray jsonArray = CollectionToJsonUtil.jsonArray(information);
        return new CommonResult(0,"",1000,jsonArray);
    }

    @RequestMapping("/selectAllInformationvue")
    @ResponseBody
    public Collection selectAllInformationvue(){
        Collection<Information> information = informationService.selectAllInformation();
        return information;
    }

    @RequestMapping("/insertInformation")
    @ResponseBody
    public int insertSubject(Information information){
        int i = informationService.insertInformation(information);
        return i;
    }

    @RequestMapping("/deleteInformation")
    @ResponseBody
    public int deleteRegistration(int i_id){
        int i = informationService.deleteInformation(i_id);
        return i;
    }

    @RequestMapping("/updateInformation")
    @ResponseBody
    public int updateRegistration(Information information){
        int i = informationService.updateInformation(information);
        return i;
    }

    @ResponseBody
    @RequestMapping("/information/add")
    public Map<String,Object> addlunbo(@RequestParam("file") MultipartFile file, HttpServletRequest request, int i_id) {
        Assert.notNull(file, "????????????????????????");
        String filename = System.currentTimeMillis()+file.getOriginalFilename();
        System.out.println(filename);
        String fName = "D:\\testFile";
        //??????????????????
        File file2 = new File(fName);
        if (!file2.exists()) {
            file2.mkdirs();
        }


        String savepath = fName+"\\"+filename;
        System.out.println("?????????????????????:"+savepath);
        Map map = new HashMap<String,Object>();
        try {
            //????????????????????????
            file.transferTo(new File(savepath));

            //??????????????????

            System.out.println(filename);
            informationService.updateInformationimg1("http://localhost:8081/"+filename,i_id);
            //??????json
            map.put("msg","ok");
            map.put("code",200);


        } catch (Exception e) {
            map.put("msg","error");
            map.put("code",0);
            e.printStackTrace();
        }

        return map;
    }

}
