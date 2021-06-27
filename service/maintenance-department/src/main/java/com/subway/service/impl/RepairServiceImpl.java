package com.subway.service.impl;

import com.subway.entity.Repair;
import com.subway.entity.vo.FaultVo;
import com.subway.entity.vo.MFaultVo;
import com.subway.entity.vo.MRepairVo;
import com.subway.mapper.RepairMapper;
import com.subway.service.RepairService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张小岚
 * @since 2021-04-25
 */
@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements RepairService {


    @Override
    public List<FaultVo> findRepairVo(String openId, int state) {
        return baseMapper.findRepairVo(openId, state);
    }
}
