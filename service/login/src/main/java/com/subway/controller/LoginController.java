package com.subway.controller;

import com.subway.entity.User;
import com.subway.entity.vo.RegisterVo;
import com.subway.jwt.JwtUtils;
import com.subway.login.WeiXin;
import com.subway.redis.utils.RedisUtils;
import com.subway.result.Result;
import com.subway.service.impl.LevelServiceImpl;
import com.subway.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("common")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private LevelServiceImpl levelService;

    @Autowired
    private RedisUtils redisUtils;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation("登录")
    @GetMapping("login")
    public Result login(String code) {
        Map<String, Object> login = userService.login(code);
        return Result.ok().setData(login);
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public Result register(@RequestBody RegisterVo registerVo) {
        System.out.println(registerVo.getUserOpenid());
        Map<String, Object> register = userService.register(registerVo);
        return Result.ok().setData(register);
    }

    @ApiOperation("修改信息")
    @PostMapping("update")
    public Result updateUserName(HttpServletRequest httpRequest, @RequestBody User user){
        String token = httpRequest.getHeader("token");
        String openId = JwtUtils.getMemberIdByJwtToken(token, "openId");
        user.setUserOpenid(openId);
        boolean b = userService.updateById(user);
        return b ? Result.ok() : Result.error();
    }
}
