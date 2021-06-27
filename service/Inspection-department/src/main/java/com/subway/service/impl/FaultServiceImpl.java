package com.subway.service.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.subway.client.CenterClient;
import com.subway.entity.Fault;
import com.subway.entity.vo.FaultVo;
import com.subway.exception.MyException;
import com.subway.mapper.FaultMapper;
import com.subway.result.Result;
import com.subway.result.ResultCode;
import com.subway.service.FaultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 张小岚
 * @since 2021-04-09
 */
@Service
public class FaultServiceImpl extends ServiceImpl<FaultMapper, Fault> implements FaultService {


    @Autowired
    private CenterClient centerClient;

    @Override
    public List<FaultVo> findRepair(String openId, String level, int state, int date,Long current, Long limit) {
        Date date1 = new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date1);
        rightNow.add(Calendar.DATE, -date);
        Date rightDate = rightNow.getTime();
        List<FaultVo> faultVo = baseMapper.findFaultVo(openId, level, state, rightDate,current - 1, limit);
        return faultVo;
    }

    @Override
    public int count(String openId, String level, int state,int date) {
        QueryWrapper<Fault> faultQueryWrapper = new QueryWrapper<>();
        faultQueryWrapper.eq("fault_state",state);
        if (level.equals("1")){
            faultQueryWrapper.eq("fault_inspection_user_id",openId);
        }
        Date date1 = new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date1);
        rightNow.add(Calendar.DATE, -date);
        Date rightDate = rightNow.getTime();
        faultQueryWrapper.ge("create_time",rightDate);
        return baseMapper.selectCount(faultQueryWrapper);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public boolean addFault(Fault fault) {
        int insert = baseMapper.insert(fault);
        if (insert == 1){
            String json = JSON.toJSONString(Result.flush());
            try {
                Result result = centerClient.sendMessage(json);
                System.out.println("s: "+result);
                if (!result.getSuccess())
                    throw new MyException(ResultCode.ERROR,"通知调度中心失败");
            } catch (Exception e) {
                e.printStackTrace();
                throw new MyException(ResultCode.ERROR,"通知调度中心失败");
            }
            return true;
        }
        return false;
    }
}
