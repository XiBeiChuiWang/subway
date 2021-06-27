package com.subway.controller;


import com.subway.entity.vo.StS;
import com.subway.exception.MyException;
import com.subway.result.Result;
import com.subway.service.OssService;

import com.subway.thread.ThreadUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
@RequestMapping("oss")
public class Alibaba_Oss {
    @Autowired
    OssService ossService;

    @ApiOperation("上传文件")
    @PostMapping("uploadOne")
    public Result add(MultipartFile file){
        String url = ossService.uploadFileAvatar(file);
        return Result.ok().data("url",url);
    }

    @ApiOperation("上传文件")
    @PostMapping("uploadAll")
    public Result add(MultipartFile[] files){
        for (MultipartFile file:files){
            System.out.println(file);
        }
        List<String> strings = ossService.uploadFileAvatar(files);

        return Result.ok().data("list",strings);
    }

    @ApiOperation("sts")
    @GetMapping("getSts")
    public Result sts(){
        StS sts = ossService.sts();
        return Result.ok().data("sts",sts);
    }

}
