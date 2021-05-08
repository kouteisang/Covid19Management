package com.covidmanage.controller;


import com.covidmanage.utils.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Slf4j
@CrossOrigin(origins = "http://192.168.0.9:8080", allowCredentials = "true")
@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/uploadImg")
    public ResponseTemplate uploadImg(@RequestParam(value = "file") MultipartFile file){
        String path = "/Users/huangcheng/Documents/Covid19Management/src/main/resources/static";
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID().toString()+suffix;
        File targetFile = new File(path, fileName);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<Object, Object> map = new HashMap<>();
        String picUrl = "http://localhost:8181/images/" + fileName;
        map.put("picUrl", picUrl);
        return ResponseTemplate.success(map);
    }
}