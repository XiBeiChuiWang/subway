package com.subway.mapper;

import com.subway.entity.Repair;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.subway.entity.vo.FaultVo;
import com.subway.entity.vo.MFaultVo;
import com.subway.entity.vo.MRepairVo;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 张小岚
 * @since 2021-04-25
 */
public interface RepairMapper extends BaseMapper<Repair> {
    public List<FaultVo> findRepairVo(String openId, int state);
}
