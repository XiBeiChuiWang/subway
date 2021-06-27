package com.subway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.subway.entity.Level;
import com.subway.mapper.LevelMapper;
import com.subway.service.LevelService;
import org.springframework.stereotype.Service;

@Service
public class LevelServiceImpl extends ServiceImpl<LevelMapper, Level> implements LevelService{
}
