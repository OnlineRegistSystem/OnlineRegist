package com.online.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.online.util.Message;

@Controller
@RequestMapping("/file")
public class UploadController {
    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
               // 这里我用到了jar包
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
 
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile((String) iter.next());
                if (file != null) {
                    String fileName = file.getOriginalFilename();
                    if(fileName.equalsIgnoreCase("")){
                    	return Message.getMessage(0, "文件为空！","");
                    }
                    String path2= Thread.currentThread()
                            .getContextClassLoader().getResource("").getPath();
//                            + "download" + File.separator;
                   int now = path2.indexOf("WEB-INF");
                   System.out.println(path2.substring(0, now));
                   path2 = path2.substring(0,now);
                    System.out.println(">>>>>>>>>>"+path2);
                    
                    String path1="file/"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+fileName.substring(fileName.lastIndexOf("."));
                    //  下面的加的日期是为了防止上传的名字一样
//                    String path = path1
//                            + new SimpleDateFormat("yyyyMMddHHmmss")
//                                    .format(new Date()) + fileName;
                    String path = path2+path1;
 
                    File localFile = new File(path);
                    System.out.println(path);
                    file.transferTo(localFile);
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("path", path1);
                    return Message.getMessage(1, "", map);
                }
 
            }
           
        }

        return Message.getMessage(0, "文件为空！","");
 
    }
    @RequestMapping("/toUpload.do")
    public String toUpload() {
        return "upload";
    }
 
    @RequestMapping("/download")
    public String download(String fileName, HttpServletRequest request,
            HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
        try {
            String path = "/home/chuankun/test/"+fileName;
                  
            InputStream inputStream = new FileInputStream(path);
 
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
 
             // 这里主要关闭。
            os.close();
 
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            //  返回值要注意，要不然就出现下面这句错误！
            //java+getOutputStream() has already been called for this response
        return null;
    }
}