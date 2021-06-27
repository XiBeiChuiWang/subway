package com.subway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.subway.entity.Fault;
import com.subway.entity.vo.FaultVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张小岚
 * @since 2021-04-09
 */
public interface FaultService extends IService<Fault> {

    public List<FaultVo> findRepair(String openId, String level,int state,int date,Long current,Long limit);

    public int count(String openId, String level,int state,int date);

    public boolean addFault(Fault fault);
}
