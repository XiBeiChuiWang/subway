package com.subway.interceptor;

import com.subway.exception.MyException;
import com.subway.jwt.JwtUtils;
import com.subway.result.ResultCode;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//等级3可通过
public class FourthLoginInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String level = JwtUtils.getMemberIdByJwtToken(token, "level");
        if (level.equals("6")){
            return true;
        }
        throw new MyException(ResultCode.LOGIN,"你没有权限");
    }
}