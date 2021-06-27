package com.subway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.subway.entity.Fault;
import com.subway.entity.vo.DispatchSubmitVo;
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
    public void agree(DispatchSubmitVo dispatchSubmitVo);
    public void refuse(DispatchSubmitVo dispatchSubmitVo);
}
