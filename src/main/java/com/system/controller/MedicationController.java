package com.system.controller;

import com.system.config.CommonResult;
import com.system.pojo.Commonsense;
import com.system.pojo.Medica;
import com.system.service.MedicatypeService;
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
 * @ClassName MedicationController
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/20 15:45
 **/
@Controller
@CrossOrigin
public class MedicationController {

    @Autowired
    MedicatypeService medicatypeService;

    @RequestMapping("/selectAllmedica")
    @ResponseBody
    public CommonResult showAll(){

        Collection<Medica> medicatypes = medicatypeService.selectAllmedica();
        return new CommonResult(0,"",1000,medicatypes);
    }

    @RequestMapping("/selectMedicaByCoId")
    @ResponseBody
    public Collection selectMedicaByCoId(Integer m_status){
        System.out.println(m_status);
        Collection<Medica> medica = medicatypeService.selectMedicaByCoId(m_status);
        System.out.println(medica);
        return medica;
    }

    @RequestMapping("/insertmedica")
    @ResponseBody
    public int insertmedica(Medica medicatype){
        int i = medicatypeService.insertmedica(medicatype);
        return i;
    }

    @RequestMapping("/deletemedica")
    @ResponseBody
    public int deletecf(int m_id){
        int i = medicatypeService.deletemedica(m_id);
        return i;
    }

    @RequestMapping("/updatemedica")
    @ResponseBody
    public int updatemedica(Medica medicatype){
        int i = medicatypeService.updatemedica(medicatype);
        return i;
    }


    @ResponseBody
    @RequestMapping("/medicaimg/add")
    public Map<String,Object> medicaimgadd(@RequestParam("file") MultipartFile file, HttpServletRequest request, int m_id) {
        Assert.notNull(file, "上传文件不能为空");
        System.out.println(m_id);
        String filename = System.currentTimeMillis()+file.getOriginalFilename();
        System.out.println(filename);
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
            medicatypeService.updateMedicaimg("http://localhost:8081/"+filename,m_id);
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
