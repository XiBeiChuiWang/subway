package com.subway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.subway.entity.Fault;
import com.subway.entity.vo.FaultMessage;
import com.subway.entity.vo.FaultVo;
import org.springframework.web.bind.annotation.PathVariable;

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
    public FaultMessage findById(String faultId);
    public List<FaultVo> findFaultVo(Long current, Long limit, int date,int state);
    public int count( int date,int state);
    public FaultVo findFaultVoById(String faultId);
}
