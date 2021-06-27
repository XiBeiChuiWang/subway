package com.subway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.subway.entity.Level;
import com.subway.entity.User;
import com.subway.entity.vo.RegisterVo;
import com.subway.exception.MyException;
import com.subway.jwt.JwtUtils;
import com.subway.login.WeiXin;
import com.subway.mapper.UserMapper;
import com.subway.redis.utils.RedisUtils;
import com.subway.result.ResultCode;
import com.subway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

}
