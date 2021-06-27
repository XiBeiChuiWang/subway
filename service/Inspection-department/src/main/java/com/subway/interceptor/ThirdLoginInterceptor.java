package com.subway.interceptor;

import com.subway.exception.MyException;
import com.subway.jwt.JwtUtils;
import com.subway.result.ResultCode;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//等级2/3可通过
public class ThirdLoginInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String level = JwtUtils.getMemberIdByJwtToken(token, "level");
        if (level.equals("2") || level.equals("3")){
            return true;
        }
        throw new MyException(ResultCode.LOGIN,"你没有权限");
    }
}
