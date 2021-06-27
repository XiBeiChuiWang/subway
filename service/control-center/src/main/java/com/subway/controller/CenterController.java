package com.subway.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.subway.entity.Fault;
import com.subway.entity.vo.FaultVo;
import com.subway.entity.vo.Template;
import com.subway.login.WeiXin;
import com.subway.result.Result;
import com.subway.service.FaultService;
import com.subway.service.impl.FaultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("center")
public class CenterController {

    @Autowired
    WebSocket webSocket;

    @Autowired
    FaultServiceImpl faultService;

    @GetMapping("/webSocket/{message}")
    public Result webSocket(@PathVariable String message){
        webSocket.sendMessage(message);
        return Result.ok();
    }

    @GetMapping("findUnRepair/{current}/{limit}/{date}")
    public Result findUnRepair(@PathVariable Long current,@PathVariable Long limit,@PathVariable int date){
        List<FaultVo> faultVo = faultService.findFaultVo(current, limit, date, 0);
        int count = faultService.count(date,0);
        System.out.println(faultVo);
        return Result.ok().data("list",faultVo).data("total",count);
    }

    @GetMapping("findRepairing/{current}/{limit}/{date}")
    public Result findRepairing(@PathVariable Long current,@PathVariable Long limit,@PathVariable int date){
        List<FaultVo> faultVo = faultService.findFaultVo(current, limit, date, 1);
        int count = faultService.count(date,0);
        return Result.ok().data("list",faultVo).data("total",count);
    }

    @GetMapping("findRepaired/{current}/{limit}/{date}")
    public Result findRepaired(@PathVariable Long current,@PathVariable Long limit,@PathVariable int date){
        List<FaultVo> faultVo = faultService.findFaultVo(current, limit, date, 2);
        int count = faultService.count(date,0);
        return Result.ok().data("list",faultVo).data("total",count);
    }
}
