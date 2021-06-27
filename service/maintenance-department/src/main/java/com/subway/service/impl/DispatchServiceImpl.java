package com.subway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.subway.entity.Dispatch;
import com.subway.entity.vo.DispatchVo;
import com.subway.entity.vo.FaultMessage;
import com.subway.entity.vo.Template;
import com.subway.exception.MyException;
import com.subway.login.WeiXin;
import com.subway.mapper.DispatchMapper;
import com.subway.result.ResultCode;
import com.subway.service.DispatchService;
import com.subway.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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



}
