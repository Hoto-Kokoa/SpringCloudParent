package com.test.controller;


import com.test.pojo.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileUploadController {

    @RequestMapping("/upload")
    public String uploadImage(MultipartHttpServletRequest multipartHttpServletRequest,HttpServletRequest request) throws IOException {
        //获取文件
        MultipartFile multipartFile=multipartHttpServletRequest.getFile("filename");
        System.out.println("文件名："+multipartFile.getName());

        //获取文件真实路径
        String realPath = request.getServletContext().getRealPath("/upload");
        System.out.println(realPath);

        //随机出文件名
        int random = (int) (Math.random() * 10000);
        System.out.println(random);


        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println(originalFilename);

        String substring = originalFilename.substring(originalFilename.indexOf("."));
        System.out.println(substring);

        String filePathAndFileName = realPath+ random + substring;
        System.out.println(filePathAndFileName);

        File file = new File(filePathAndFileName);


        multipartFile.transferTo(file);
        return "welcome";
    }
}
