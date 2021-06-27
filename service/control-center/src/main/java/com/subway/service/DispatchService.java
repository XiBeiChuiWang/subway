package com.subway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.subway.entity.Dispatch;
import com.subway.entity.vo.DispatchVo;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张小岚
 * @since 2021-05-15
 */
public interface DispatchService extends IService<Dispatch> {
    public void dispatch(Dispatch dispatch);

    public List<DispatchVo> findDispatchVo(Long current, Long limit, String openId, String level,int date);
}
