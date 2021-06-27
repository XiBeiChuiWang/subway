package com.subway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.subway.entity.Dispatch;
import com.subway.entity.Fault;
import com.subway.entity.User;
import com.subway.entity.vo.DispatchVo;
import com.subway.entity.vo.FaultMessage;
import com.subway.entity.vo.Template;
import com.subway.exception.MyException;
import com.subway.jwt.JwtUtils;
import com.subway.login.WeiXin;
import com.subway.mapper.DispatchMapper;
import com.subway.result.Result;
import com.subway.result.ResultCode;
import com.subway.service.DispatchService;
import com.subway.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张小岚
 * @since 2021-05-15
 */
@Service
public class DispatchServiceImpl extends ServiceImpl<DispatchMapper, Dispatch> implements DispatchService {

    @Autowired
    private FaultServiceImpl faultService;

    @Autowired
    private SnowFlake snowFlake;

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void dispatch(Dispatch dispatch) {
        String s = String.valueOf(snowFlake.nextId());
        dispatch.setDispatchId(s);
        baseMapper.insert(dispatch);
        FaultMessage faultMessage = faultService.findById(dispatch.getDispatchFaultId());

        String page = "pages/function/repair/repair-receive/repair-receive?faultId=" + faultMessage.getFaultId()+"&dispatchId="+s;
        System.out.println(page);
        Template faultTemplate = Template.getFaultTemplate(dispatch.getDispatchToUserId(), "_x38eq_m_iOTEQHYFNe5ItSXVfuhOMFCmz6itihnVlQ", page,
                "trial", "zh_CN", faultMessage.getFaultId(), faultMessage.getFaultEquipment(),
                faultMessage.getUserName(), faultMessage.getFaultPlace(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(faultMessage.getCreateTime()));
        String send = WeiXin.send(faultTemplate);
        try {
            JSONObject jsonObject = new JSONObject(send);
            if (!jsonObject.get("errcode").equals(0)){
                System.out.println(jsonObject.get("errcode"));
                throw new MyException(ResultCode.ERROR,"发送失败",null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new MyException(ResultCode.ERROR,"错误",null);
        }

    }

    @Override
    public List<DispatchVo> findDispatchVo(Long current, Long limit, String openId, String level,int date) {
        Date date1 = new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date1);
        rightNow.add(Calendar.DATE, -date);
        Date rightDate = rightNow.getTime();
        return baseMapper.findDispatchVo(current - 1, limit, openId, level,rightDate);
    }


}
