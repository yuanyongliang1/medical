package com.system.controller;

import com.system.config.CollectionToJsonUtil;
import com.system.config.CommonResult;
import com.system.pojo.Classification;
import com.system.service.ClassificationService;
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
 * @ClassName ClassificationController
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/20 13:03
 **/

@CrossOrigin
@Controller
public class ClassificationController {
    @Autowired
    ClassificationService classificationService;

   @RequestMapping("/selectCfAll")
    @ResponseBody
    public CommonResult showAll(){

        Collection<Classification> selectAll = classificationService.selectAll();
        JSONArray jsonArray = CollectionToJsonUtil.jsonArray(selectAll);
       System.out.println(jsonArray);
        return new CommonResult(0,"",1000,jsonArray);
    }

    @RequestMapping("/selectAllClassificationcon")
    @ResponseBody
    public Collection<Classification> selectAllSubjectcon(){
        Collection<Classification> subject = classificationService.selectAll();
        return subject;
    }

    @RequestMapping("/insertcf")
    @ResponseBody
    public int insertcf(Classification classification){
        int i = classificationService.insertcf(classification);
        return i;
    }

    @RequestMapping("/deletecf")
    @ResponseBody
    public int deletecf(int c_id){
        int i = classificationService.deletecf(c_id);
        return i;
    }

    @RequestMapping("/updatecf")
    @ResponseBody
    public int updatecf(Classification classification){
        System.out.println(classification);
        int i= classificationService.updatecf(classification);
        System.out.println(i);
        return i;
    }


    /**
     * 更新图片
     * @param file
     * @param request
     * @param c_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/classification/add")
    public Map<String,Object> addimgClassification(@RequestParam("file") MultipartFile file, HttpServletRequest request, int c_id) {
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
            classificationService.updateClassification("http://localhost:8081/"+filename,c_id);
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

}
