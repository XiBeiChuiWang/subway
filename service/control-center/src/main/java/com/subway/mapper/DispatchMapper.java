package com.subway.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.subway.entity.Dispatch;
import com.subway.entity.vo.DispatchVo;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张小岚
 * @since 2021-05-15
 */
public interface DispatchMapper extends BaseMapper<Dispatch> {
    public List<DispatchVo> findDispatchVo(Long current, Long limit, String openId, String level, Date date);
}
