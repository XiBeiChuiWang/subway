package com.subway.exception;

import com.subway.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error().setMessage("执行了全局异常处理");
    }

    //自定义异常处理
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    public Result error(MaxUploadSizeExceededException e){
        e.printStackTrace();
        return Result.error().setMessage("图片过大！");
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result error(MyException e){
        e.printStackTrace();
        Result error = Result.error();
        if (e.getHashMap() != null){
            error.setData(e.getHashMap());
        }
        Result result = error.setMessage(e.getMessage()).setCode(e.getCode());
        logger.info(result.toString());
        return result;
    }
}
