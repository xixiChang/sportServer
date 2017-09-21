package com.tcl.work.sport.controller;

import com.tcl.work.sport.model.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static com.tcl.work.sport.constant.Constant.OK;

/**
 * Created by Emcc on 17-9-19.
 */
@RestController(value = "/file")
public class FileUploader {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Value("${custom.file.filePath}")
    private String filePath;
    @Value("${custom.file.fileType}")
    private String fileType;

    @PostMapping("/image")
    public ResponseResult upLoadHeadImage(@RequestParam("id") String id,
                                          @RequestParam("des") String des,
                                          @RequestParam("file")MultipartFile uploadfile){
        ResponseResult responseResult = new ResponseResult();

        if (des == null || !des.matches("^(activity|head)$")){
            responseResult.setMsg("上传请求需要目的参数(activity|head)");
            return responseResult;
        }
        String name;
        try {
            byte[] bytes = uploadfile.getBytes();
            name = String.valueOf(new Date().getTime()) + fileType;
            Path path = Paths.get(filePath + des + File.pathSeparator + name);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return responseResult;
        }
        responseResult.setStatus(OK);
        responseResult.setResult(name);

        return responseResult;
    }


}
