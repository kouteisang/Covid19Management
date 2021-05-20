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
@CrossOrigin(origins = "http://172.20.10.2:8080", allowCredentials = "true")
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


    @PostMapping("/uploadImgs")
    public ResponseTemplate uploadImgs(@RequestParam(value = "file") MultipartFile[] file){
        List<String> fileUrls = new ArrayList<>();
        for(int i = 0; i < file.length; i ++){
            String path = "/Users/huangcheng/Documents/Covid19Management/src/main/resources/static";
            String suffix = file[i].getOriginalFilename().substring(file[i].getOriginalFilename().lastIndexOf("."));
            String fileName = UUID.randomUUID().toString()+suffix;
            File targetFile = new File(path, fileName);
            try {
                file[i].transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String picUrl = "http://localhost:8181/images/" + fileName;
            fileUrls.add(picUrl);
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("fileUrls", fileUrls);
        return ResponseTemplate.success(map);
    }
}
