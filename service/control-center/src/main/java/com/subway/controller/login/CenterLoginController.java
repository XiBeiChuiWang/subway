package com.subway.controller.login;
import com.subway.entity.vo.UserLogin;
import com.subway.result.Result;
import com.subway.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/center")
public class CenterLoginController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserLogin userLogin){
        HashMap user = userService.findUser(userLogin);
        return Result.ok().setData(user);
    }

}
