package com.subway.client;

import com.subway.exception.MyException;
import com.subway.result.Result;
import com.subway.result.ResultCode;
import org.springframework.stereotype.Component;

@Component
public class CenterClientImpl implements CenterClient{
    @Override
    public Result sendMessage(String message) {
        System.out.println("message");
        throw new MyException(ResultCode.ERROR,"网络错误");
    }
}
