package com.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.config.CollectionToJsonUtil;
import com.system.config.CommonResult;
import com.system.pojo.Commonsense;
import com.system.pojo.Topicdetails;
import com.system.service.TopicdetailsService;
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
 * @ClassName MedicationController
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/20 15:45
 **/
@Controller
@CrossOrigin
public class TopicdetailsController {

    @Autowired
    TopicdetailsService topicdetailsService;

   /* @RequestMapping("/selectAllTopicdetails")
    @ResponseBody
    public CommonResult showAll(){

        Collection<Topicdetails> topicdetails = topicdetailsService.selectAllTopicdetails();
        System.out.println(topicdetails.toString());

        JSONArray jsonArray = CollectionToJsonUtil.jsonArray(topicdetails);
        return new CommonResult(0,"",1000,topicdetails);
    }*/


    @RequestMapping("/selectAllTopicdetails")
    @ResponseBody
    public Map<String,Object> showAll(@RequestParam(value = "page",defaultValue = "1")Integer pn,
                                      @RequestParam(value = "limit",defaultValue = "10")Integer limit){
        PageHelper.startPage(pn,limit);
        Collection<Topicdetails> topicdetails = topicdetailsService.selectAllTopicdetails();
        PageInfo page = new PageInfo((List) topicdetails,limit);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("code",0);
        pageMap.put("msg","");
        pageMap.put("data",page.getList());
        pageMap.put("count",page.getTotal());
        return pageMap;
    }

    @RequestMapping("/selectTopicdetailsById")
    @ResponseBody
    public Topicdetails selectCommonsenseById(Integer t_id){
        Topicdetails information = topicdetailsService.topicdetailsById(t_id);
        return information;
    }

    @RequestMapping("/selectTopicdetailsByCoId")
    @ResponseBody
    public Collection selectTopicdetailsByCoId(Integer t_s_id){
        System.out.println(t_s_id);
        Collection<Topicdetails> topicdetails = topicdetailsService.selectTopicdetailsByCoId(t_s_id);
        System.out.println(topicdetails);
        return topicdetails;
    }


    @RequestMapping("/insertTopicdetails")
    @ResponseBody
    public int insertTopicdetails(Topicdetails topicdetails){
        int i = topicdetailsService.insertTopicdetails(topicdetails);
        return i;
    }

    @RequestMapping("/deleteTopicdetails")
    @ResponseBody
    public int deletecf(int t_id){
        int i = topicdetailsService.deleteTopicdetails(t_id);
        return i;
    }

    @RequestMapping("/updateTopicdetails")
    @ResponseBody
    public int updatemedica(Topicdetails topicdetails){
        int i = topicdetailsService.updateTopicdetails(topicdetails);
        return i;
    }
}
