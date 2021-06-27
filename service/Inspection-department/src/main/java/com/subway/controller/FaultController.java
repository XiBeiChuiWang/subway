package com.subway.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.subway.entity.Fault;
import com.subway.entity.vo.FaultVo;
import com.subway.jwt.JwtUtils;
import com.subway.result.Result;
import com.subway.service.impl.FaultServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 张小岚
 * @since 2021-04-09
 */
@RestController
@RequestMapping("inspection")
public class FaultController {

    @Autowired
    private FaultServiceImpl faultService;


    @ApiOperation("上报故障")
    @PostMapping("add")
    public Result add(@RequestBody Fault fault, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        String openId = JwtUtils.getMemberIdByJwtToken(token, "openId");
        fault.setFaultInspectionUserId(openId);
        fault.setFaultState(0);
        boolean save = faultService.addFault(fault);
        return save ? Result.ok().setMessage("上报成功") : Result.error().setMessage("上报失败");
    }

    @ApiOperation("显示故障页面")
    @GetMapping("findUnRepair/{current}/{limit}/{date}")
    public Result findUnRepair(@PathVariable Long current, @PathVariable Long limit, @PathVariable int date, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        String openId = JwtUtils.getMemberIdByJwtToken(token, "openId");        String level = JwtUtils.getMemberIdByJwtToken(token, "level");
        List<FaultVo> repair = faultService.findRepair(openId, level, 0, date, current, limit);
        int count = faultService.count(openId, level, 0, date);
        return Result.ok().data("list", repair).data("total", count);
    }

    @ApiOperation("显示故障页面")
    @GetMapping("findRepairing/{current}/{limit}/{date}")
    public Result findRepairing(@PathVariable Long current, @PathVariable Long limit, @PathVariable int date, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        String openId = JwtUtils.getMemberIdByJwtToken(token, "openId");
        String level = JwtUtils.getMemberIdByJwtToken(token, "level");
        List<FaultVo> repair = faultService.findRepair(openId, level, 1, date, current, limit);
        int count = faultService.count(openId, level, 1, date);
        return Result.ok().data("list", repair).data("total", count);
    }

    @ApiOperation("显示故障页面")
    @GetMapping("findRepaired/{current}/{limit}/{date}")
    public Result findRepair(@PathVariable Long current, @PathVariable Long limit, @PathVariable int date, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        String openId = JwtUtils.getMemberIdByJwtToken(token, "openId");
        String level = JwtUtils.getMemberIdByJwtToken(token, "level");
        List<FaultVo> repair = faultService.findRepair(openId, level, 2, date, current, limit);
        int count = faultService.count(openId, level, 2, date);
        return Result.ok().data("list", repair).data("total", count);
    }

}

