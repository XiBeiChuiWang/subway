package com.subway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.subway.entity.Fault;
import com.subway.entity.vo.FaultMessage;
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
    public FaultMessage findById(String faultId);

    public List<FaultVo> findFaultVo(Long current, Long limit, Date date,int state);

    public FaultVo findFaultVoById(String faultId);
}
