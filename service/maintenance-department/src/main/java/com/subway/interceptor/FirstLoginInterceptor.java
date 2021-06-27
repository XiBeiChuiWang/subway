package com.subway.interceptor;

import com.subway.exception.MyException;
import com.subway.jwt.JwtUtils;
import com.subway.result.ResultCode;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截token错误或者无token
public class FirstLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (JwtUtils.checkToken(request)){
            return true;
        }
        throw new MyException(ResultCode.LOGIN,"你没有登陆，请登录");
    }
}
