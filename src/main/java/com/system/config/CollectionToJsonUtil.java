package com.system.config;


import net.sf.json.JSONArray;

import java.util.Collection;

/**
 * @ClassName CollectionToJsonUtil
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/20 16:39
 **/
public class CollectionToJsonUtil {
    public static JSONArray jsonArray(Collection collection){
        JSONArray json = JSONArray.fromObject(collection);
        return json;
    }
}
