package com.subway;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.subway.entity.vo.Template;
import com.subway.jwt.JwtUtils;
import com.subway.login.WeiXin;
import com.subway.utils.SnowFlake;
import io.jsonwebtoken.Jwts;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01 {

    @Test
    public void a(){
        System.out.println(JwtUtils.getJwtToken("odHJH46-EtgJIZ3YWYDWdu2GI-UY", "3", 30));
//        System.out.println(1000*60*60*24*30);
        long a = 1000*60*60*24*30L;
        System.out.println(a);
//        SnowFlake snowFlake = new SnowFlake(1, 1);
//        System.out.println(snowFlake.nextId());
    }
}
