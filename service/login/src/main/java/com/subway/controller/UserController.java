package com.subway.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.subway.entity.User;
import com.subway.result.Result;
import com.subway.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("common")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("findRepairUser")
    public Result findRepairUser(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_department_id","2");
        List<User> list = userService.list(userQueryWrapper);
        return Result.ok().data("list",list);
    }

    @GetMapping("findHeader")
    public Result findHeader(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.in("user_level",new String[]{"3","6","9"});

        List<User> list = userService.list(userQueryWrapper);
        return Result.ok().data("list",list);
    }

    @GetMapping("findUserById/{openId}")
    public Result findUserById(@PathVariable String openId){
        User byId = userService.getById(openId);
        return Result.ok().data("user",byId);
    }
}
