package com.subway.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.subway.entity.Repair;
import com.subway.entity.vo.DispatchSubmitVo;
import com.subway.entity.vo.FaultVo;
import com.subway.entity.vo.MFaultVo;
import com.subway.entity.vo.MRepairVo;
import com.subway.jwt.JwtUtils;
import com.subway.result.Result;
import com.subway.service.impl.FaultServiceImpl;
import com.subway.service.impl.RepairServiceImpl;
import io.swagger.annotations.ApiOperation;
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
 * @since 2021-04-25
 */
@RestController
@RequestMapping("/maintenance")
public class RepairController {

    @Autowired
    private RepairServiceImpl repairService;

    @Autowired
    private FaultServiceImpl faultService;

    @ApiOperation("添加维修记录")
    @PostMapping("/addRepair")
    public Result add(@RequestBody Repair repair,HttpServletRequest httpServletRequest){
        boolean save = repairService.save(repair);
        return save ? Result.ok() : Result.error();
    }

    @PostMapping("/agree")
    public Result agree(@RequestBody DispatchSubmitVo dispatchSubmitVo){
        faultService.agree(dispatchSubmitVo);
        return Result.ok();
    }

    @PostMapping("/refuse")
    public Result refuse(@RequestBody DispatchSubmitVo dispatchSubmitVo){
        faultService.refuse(dispatchSubmitVo);
        return Result.ok();
    }

    @ApiOperation("查找所有维修记录")
    @GetMapping("/findUnRepair")
    public Result findUnRepair(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        String openId = JwtUtils.getMemberIdByJwtToken(token, "openId");
        List<FaultVo> repairVo = repairService.findRepairVo(openId, 1);
        return Result.ok().data("list",repairVo);
    }

}

