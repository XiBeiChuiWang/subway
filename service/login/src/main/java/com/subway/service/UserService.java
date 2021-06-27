package com.subway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.subway.entity.User;
import com.subway.entity.vo.RegisterVo;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张小岚
 * @since 2021-04-09
 */
public interface UserService extends IService<User> {
    public Map<String,Object> login(String code);

    public Map<String,Object> register(RegisterVo registerVo);
}
