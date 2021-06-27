package com.subway.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.subway.entity.Dispatch;
import com.subway.entity.vo.DispatchVo;
import com.subway.entity.vo.FaultVo;
import com.subway.jwt.JwtUtils;
import com.subway.result.Result;
import com.subway.service.impl.DispatchServiceImpl;
import com.subway.service.impl.FaultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 张小岚
 * @since 2021-05-15
 */
@RestController
@RequestMapping("/center")
public class DispatchController {

    @Autowired
    private DispatchServiceImpl dispatchService;

    @Autowired
    private FaultServiceImpl faultService;


    @PostMapping("dispatch")
    public Result dispatch(@RequestBody Dispatch dispatch ,HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        String openId = JwtUtils.getMemberIdByJwtToken(token, "openId");
        dispatch.setDispatchFromUserId(openId);
        dispatch.setDispatchState("0");
        dispatchService.dispatch(dispatch);
        return Result.ok();
    }

    @GetMapping("findFaultById/{faultId}")
    public Result findFaultById(@PathVariable String faultId){
        FaultVo faultVo = faultService.findFaultVoById(faultId);
        return Result.ok().data("faultVo",faultVo);
    }


    @GetMapping("findDispatch/{current}/{limit}/{date}")
    public Result findDispatch(@PathVariable Long current, @PathVariable Long limit,@PathVariable int date, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        String openId = JwtUtils.getMemberIdByJwtToken(token, "openId");
        String level = JwtUtils.getMemberIdByJwtToken(token, "level");

        List<DispatchVo> dispatch = dispatchService.findDispatchVo(current, limit, openId, level,date);
        QueryWrapper<Dispatch> dispatchQueryWrapper = new QueryWrapper<>();
        if (level.equals("7")){
            dispatchQueryWrapper.eq("dispatch_from_user_id",openId);
        }
        int count = dispatchService.count(dispatchQueryWrapper);
        return Result.ok().data("total",count).data("list",dispatch);
    }


}

