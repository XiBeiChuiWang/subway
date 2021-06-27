package com.subway.service;

import com.subway.entity.Repair;
import com.baomidou.mybatisplus.extension.service.IService;
import com.subway.entity.vo.FaultVo;
import com.subway.entity.vo.MFaultVo;
import com.subway.entity.vo.MRepairVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张小岚
 * @since 2021-04-25
 */
public interface RepairService extends IService<Repair> {
    public List<FaultVo> findRepairVo(String openId,int state);
}
