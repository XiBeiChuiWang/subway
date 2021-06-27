package com.subway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.subway.entity.User;
import com.subway.entity.vo.UserLogin;
import com.subway.exception.MyException;
import com.subway.jwt.JwtUtils;
import com.subway.mapper.UserMapper;
import com.subway.result.Result;
import com.subway.result.ResultCode;
import com.subway.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张小岚
 * @since 2021-04-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public HashMap findUser(UserLogin userLogin) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_tel",userLogin.getUserTel())
                .eq("user_password",userLogin.getUserPassword());
        User user = baseMapper.selectOne(userQueryWrapper);
        if (user == null){
            throw new MyException(ResultCode.ERROR,"账号密码错误");
        }

        user.setUserPassword(null);

        String jwtToken = JwtUtils.getJwtToken(user.getUserOpenid(), user.getUserLevel(), 30);
        HashMap hashMap = new HashMap();
        hashMap.put("token",jwtToken);
        hashMap.put("user",user);
        return hashMap;
    }
}
