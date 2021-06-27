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

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private LevelServiceImpl levelService;


    @Override
    public Map<String,Object> login(String code) {
        String openId = null;
        try {
            //根据code拿到openid
            String sessionKeyOrOpenId = WeiXin.getSessionKeyOrOpenId(code);
            JSONObject jsonObject = new JSONObject(sessionKeyOrOpenId);
            openId = (String) jsonObject.get("openid");
            System.out.println(openId);
        } catch (JSONException e) {
//            e.printStackTrace();
            throw new MyException(ResultCode.ERROR,"code无效",null);
        }
        //根据openid查到user对象
        User user = baseMapper.selectById(openId);
        System.out.println(user);
        HashMap<String, Object> stringStringHashMap = new HashMap<>();
        //如果没有
        if (user == null){
            //将openid送回前端，让他下次来时发过来
            stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("openId",openId);

            //将openId存入redis来防止造假

            redisUtils.set(openId,"true",1000*60 * 60);


            throw new MyException(ResultCode.FORWARD,"跳转",stringStringHashMap);
        }

        String token = JwtUtils.getJwtToken(openId, user.getUserLevel(), 30);
        System.out.println(token);
        stringStringHashMap.put("token",token);
        stringStringHashMap.put("user",user);
        return stringStringHashMap;
    }

    @Override
    public Map<String,Object> register(RegisterVo registerVo) {
        String userOpenid = registerVo.getUserOpenid();
        System.out.println(userOpenid);
        if (redisUtils.hasKey(userOpenid)){
//            redisUtils.del(userOpenid);
        }else {
            throw new MyException(ResultCode.ERROR,"openid错误");
        }

        QueryWrapper<Level> wrapper = new QueryWrapper<>();
        wrapper.eq("invitation_code", registerVo.getInvitationCode());
        Level one = levelService.getOne(wrapper);

        if (one != null) {
            User user = new User(registerVo.getUserOpenid(), registerVo.getUserName()
                    , registerVo.getUserSex(), registerVo.getUserBirthday(), registerVo.getUserTel(), registerVo.getUserAvatar()
                    , one.getDepartmentId(), one.getLevel());

            int save = baseMapper.insert(user);
            if (save == 1) {
                String jwtToken = JwtUtils.getJwtToken(user.getUserOpenid(), user.getUserLevel(), 30);
                HashMap<String, Object> stringObjectHashMap = new HashMap<>();
                stringObjectHashMap.put("token",jwtToken);
                stringObjectHashMap.put("user",user);
                return stringObjectHashMap;
            }else {
                throw new MyException(ResultCode.ERROR,"网络错误，请重新登录");
            }
        } else {
            throw new MyException(ResultCode.ERROR, "邀请码错误");
        }
    }

}
