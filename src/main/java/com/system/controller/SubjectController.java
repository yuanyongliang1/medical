package com.system.controller;

import com.system.config.CollectionToJsonUtil;
import com.system.config.CommonResult;
import com.system.pojo.Subject;
import com.system.service.SubjectService;
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
 * @ClassName SubjectController
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/21 17:39
 **/
@Controller
@CrossOrigin
public class SubjectController {
    @Autowired
    SubjectService subjectService;


    @RequestMapping("/selectAllSubject")
    @ResponseBody
    public CommonResult selectAllSubject(){

        Collection<Subject> subject = subjectService.selectAllSubject();
        JSONArray jsonArray = CollectionToJsonUtil.jsonArray(subject);
        return new CommonResult(0,"",1000,jsonArray);
    }

    @RequestMapping("/selectAllSubjectcon")
    @ResponseBody
    public Collection<Subject> selectAllSubjectcon(){

        Collection<Subject> subject = subjectService.selectAllSubject();

        return subject;
    }

    @RequestMapping("/insertSubject")
    @ResponseBody
    public int insertSubject(Subject subject){
        int i = subjectService.insertSubject(subject);
        return i;
    }

    @RequestMapping("/deleteSubject")
    @ResponseBody
    public int deleteRegistration(int s_id){
        int i = subjectService.deleteSubject(s_id);
        return i;
    }

    @RequestMapping("/updateSubject")
    @ResponseBody
    public int updateRegistration(Subject subject){
        System.out.println(subject);
        int i = subjectService.updateSubject(subject);
        return i;
    }


    /**
     * 更新图片
     * @param file
     * @param request
     * @param s_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/lunbo/add")
    public Map<String,Object> addlunbo(@RequestParam("file") MultipartFile file, HttpServletRequest request,int s_id) {
        Assert.notNull(file, "上传文件不能为空");
        String filename = System.currentTimeMillis()+file.getOriginalFilename();
        String fName = "D:\\testFile";
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
            subjectService.updateSubjectimg1("http://localhost:8081/"+filename,s_id);
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
