package com.tcl.work.sport.controller;

import com.tcl.work.sport.model.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
import static com.tcl.work.sport.constant.Constant.USER_DEFAULT_IMAGE_URL;

/**
 * Created by Emcc on 17-9-19.
 */
@RestController
@RequestMapping(path = "/file")
public class FileUploader {

    private static final String Msg = "uploadFile";
    private Logger logger = Logger.getLogger(getClass().getName());


    @Value("${custom.file.filePath}")
    private String filePath;
    @Value("${custom.file.fileType}")
    private String fileType;
    @Value("${custom.apache.path}")
    private String apachePath;

    @PostMapping(path = "/image")
    public ResponseResult upLoadHeadImage(@RequestParam("des") String des,
                                          @RequestParam("image") MultipartFile uploadfile) {


        ResponseResult responseResult = new ResponseResult();

        if (des == null || !des.matches("^(activity|head)$")) {
            responseResult.setMsg("上传请求需要目的参数(activity|head)");
            return responseResult;
        }
        String name;
        try {
            byte[] bytes = uploadfile.getBytes();
            name = String.valueOf(new Date().getTime()) + fileType;
            Path path = Paths.get(filePath + des + File.separator + name);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            responseResult.setMsg("文件处理异常,请重试.");
            return responseResult;
        }
        responseResult.setStatus(OK);
        responseResult.setMsg(Msg);
        responseResult.setType(des);
        /**
         * not real image url!
         */
        responseResult.setResult(apachePath + des + File.separator + name);

        return responseResult;
    }


}
