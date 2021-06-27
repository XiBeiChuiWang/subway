package com.subway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.subway.entity.Fault;
import com.subway.entity.vo.FaultVo;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张小岚
 * @since 2021-04-09
 */
public interface FaultMapper extends BaseMapper<Fault> {

    public List<FaultVo> findFaultVo(String openId, String level, int state, Date date, Long current, Long limit);
}
