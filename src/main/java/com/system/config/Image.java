package com.system.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static java.lang.System.out;

/**
 * @ClassName Image
 * @Description TODO
 * @Author 15135
 * @Date 2020/11/23 11:33
 **/
@Controller
@CrossOrigin
/*@RequestMapping(value = "${adminPath}/basedata/image")*/
public class Image{

   /* @RequestMapping("/toFindImg")
    public void picToJSP(@RequestParam("imgUrl") String imgUrl, HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
        //读取本地图片输入流
        FileInputStream inStream = new FileInputStream("D:/image/123.jpg");

//byte数组用于存放图片字节数据
        byte[] buff = new byte[inSteam.available()];

        inStream.read(buff);
        inStream.close();

//设置发送到客户端的响应内容类型
        response.setContentType("image/*");

        OutputStream outStream = response.getOutputStream();
        out.write(buff);
        out.close();
    }*/
   @ResponseBody
   @RequestMapping("/readImg")
   public void readImg(String filePath, HttpServletRequest request, HttpServletResponse response) {
       FileInputStream in;
       try {
           request.setCharacterEncoding("utf-8");
           //页面img标签中src中传入的真是图片地址路径
           String path = request.getParameter("D:/image/123.jpg");
           String filePathEcode = new String(path.trim().getBytes(), "UTF-8");
           response.setContentType("application/octet-stream;charset=UTF-8");
           //图片读取路径
           in = new FileInputStream(filePathEcode);
           // 得到文件大小
           int i = in.available();
           //创建存放文件内容的数组
           byte[] data = new byte[i];
           in.read(data);
           in.close();
           //把图片写出去
           OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
           outputStream.write(data);
           //将缓存区的数据进行输出
           outputStream.flush();
           outputStream.close();
       } catch (Exception e) {

       }
   }


}
