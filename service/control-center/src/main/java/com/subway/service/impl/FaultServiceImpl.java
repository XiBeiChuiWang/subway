package com.subway.service.impl;




import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.subway.entity.Fault;
import com.subway.entity.vo.FaultMessage;
import com.subway.entity.vo.FaultVo;
import com.subway.mapper.FaultMapper;
import com.subway.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public FaultMessage findById(String faultId) {
        return baseMapper.findById(faultId);
    }

    @Override
    public List<FaultVo> findFaultVo(Long current, Long limit, int date,int state) {
        Date date1 = new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date1);
        rightNow.add(Calendar.DATE, -date);
        Date rightDate = rightNow.getTime();
        return baseMapper.findFaultVo(current - 1,limit,rightDate,state);
    }

    @Override
    public int count(int date, int state) {
        QueryWrapper<Fault> faultServiceQueryWrapper = new QueryWrapper<>();
        faultServiceQueryWrapper.eq("fault_state", state);
        Date date1 = new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date1);
        rightNow.add(Calendar.DATE, -date);
        Date rightDate = rightNow.getTime();
        faultServiceQueryWrapper.ge("create_time",rightDate);
        return baseMapper.selectCount(faultServiceQueryWrapper);
    }

    @Override
    public FaultVo findFaultVoById(String faultId) {
        return baseMapper.findFaultVoById(faultId);
    }
}
