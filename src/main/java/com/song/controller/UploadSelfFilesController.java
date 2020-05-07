package com.song.controller;

import com.song.pojo.Message;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UploadSelfFilesController {

    @RequestMapping("/uploadFile")
    @ResponseBody
    public Message upload(MultipartFile file, HttpServletRequest request) throws Exception {

        //获取文件名
        String name="";
        if (file != null) {
            long size = file.getSize();
            if (size > 5242880) {//文件设置大小，我这里设置5M。
                throw new Exception("文件超过5M了");
            }
            name = file.getOriginalFilename();//直接返回文件的名字
//            String subffix = name.substring(name.lastIndexOf(".") + 1);//我这里取得文件后缀
//            String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//文件保存进来，我给他重新命名，数据库保存有原本的名字，所以输出的时候再把他附上原本的名字就行了。
            String filepath = request.getServletContext().getRealPath("/") + "files\\";//获取项目路径到webapp
            File file1 = new File(filepath);
            if (!file1.exists()) {//目录不存在就创建
                file1.mkdirs();
            }
            file.transferTo(file1);//保存文件
//            file.transferTo(new File(file1 + "\\" + fileName + "." + subffix));//保存文件
        }
        return Message.success("上传成功");
    }
}
