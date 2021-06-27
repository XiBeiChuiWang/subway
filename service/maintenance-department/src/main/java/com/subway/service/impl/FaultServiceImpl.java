package com.subway.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.subway.client.CenterClient;
import com.subway.entity.Dispatch;
import com.subway.entity.Fault;
import com.subway.entity.User;
import com.subway.entity.vo.DispatchSubmitVo;
import com.subway.entity.vo.Template;
import com.subway.exception.MyException;
import com.subway.login.WeiXin;
import com.subway.mapper.FaultMapper;
import com.subway.result.Result;
import com.subway.result.ResultCode;
import com.subway.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 张小岚
 * @since 2021-04-09
 */
@Service
public class FaultServiceImpl extends ServiceImpl<FaultMapper, Fault> implements FaultService {

    @Autowired
    private DispatchServiceImpl dispatchService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CenterClient centerClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void agree(DispatchSubmitVo dispatchSubmitVo) {

        Dispatch dispatch = dispatchService.getById(dispatchSubmitVo.getDispatchId());
        dispatch.setDispatchState("1");
        dispatchService.updateById(dispatch);

        Fault fault = baseMapper.selectById(dispatchSubmitVo.getFaultId());
        fault.setFaultRepairUserId(dispatchSubmitVo.getRepairUserId());
        if (fault.getFaultControlUserId() != null) {
            throw new MyException(ResultCode.ERROR, "此订单已被处理！");
        }
        fault.setFaultControlUserId(dispatch.getDispatchFromUserId());
        fault.setFaultState(1);
        baseMapper.updateById(fault);

        User byId = userService.getById(dispatch.getDispatchToUserId());
        String s = byId.getUserName();


        Template agreeTemplate = Template.getAgreeTemplate(fault.getFaultInspectionUserId(), "oYPlXNoJ5SFL2-spLJaNb8j2gJDVOsaUJvFsUU5blY8",
                "index", "trial", "zh_CN", fault.getFaultId(), fault.getFaultEquipment(),
                fault.getFaultDescribe(), s, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        String send = WeiXin.send(agreeTemplate);
        try {
            JSONObject jsonObject = new JSONObject(send);
            if (!jsonObject.get("errcode").equals(0)) {
                System.out.println(jsonObject.get("errcode"));
                throw new MyException(ResultCode.ERROR, "发送失败", null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new MyException(ResultCode.ERROR, "错误", null);
        }


        try {
            Result agree = Result.agree();
            Result result = centerClient.sendMessage(JSON.toJSONString(agree));
            if (!result.getSuccess())
                throw new MyException(ResultCode.ERROR, "通知调度中心失败");
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ResultCode.ERROR, "通知调度中心失败");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refuse(DispatchSubmitVo dispatchSubmitVo) {
        Fault fault = baseMapper.selectById(dispatchSubmitVo.getFaultId());

        Dispatch dispatch = dispatchService.getById(dispatchSubmitVo.getDispatchId());
        dispatch.setDispatchState("2");
        dispatchService.updateById(dispatch);

        User from = userService.getById(dispatch.getDispatchFromUserId());
        User to = userService.getById(dispatch.getDispatchToUserId());

        String fromS = from.getUserName();
        String toS = to.getUserName();
        String faults = fault.getFaultEquipment() + " - " + fault.getFaultPlace() + " - " + fault.getFaultDescribe();

        Template refuseTemplate = Template.getRefuseTemplate(from.getUserOpenid(), "kxa-qSFVG1VzbfhcqSdzNZjIU8XDHa3MbsB72UzwBTw",
                "index", "trial", "zh_CN", fault.getFaultId(), faults, fromS, toS, dispatchSubmitVo.getRefused());
        String send = WeiXin.send(refuseTemplate);
        try {
            JSONObject jsonObject = new JSONObject(send);
            if (!jsonObject.get("errcode").equals(0)) {
                System.out.println(jsonObject.get("errcode"));
                throw new MyException(ResultCode.ERROR, "发送失败", null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new MyException(ResultCode.ERROR, "错误", null);
        }

        try {
            Result refuse = Result.refuse();
            Result result = centerClient.sendMessage(JSON.toJSONString(refuse));
            if (!result.getSuccess())
                throw new MyException(ResultCode.ERROR, "通知调度中心失败");
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ResultCode.ERROR, "通知调度中心失败");
        }
    }
}
