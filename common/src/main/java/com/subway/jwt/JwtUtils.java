package com.subway.jwt;

import com.subway.exception.MyException;
import com.subway.result.ResultCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author helen
 * @since 2019/10/16
 */
public class JwtUtils {

    //常量
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO"; //秘钥

    //生成token字符串的方法
    public static String getJwtToken(String openId, String level, long time) {

        time = 1000 * 60 * 60 * 24 * time;
        if (time < 0){
            throw new MyException(ResultCode.ERROR,"溢出");
        }
        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")

                .setSubject("subway")
                .setIssuedAt(new Date())

                .setExpiration(new Date(System.currentTimeMillis() + time))

                .claim("openId", openId)  //设置token主体部分 ，存储用户信息
                .claim("level", level)

                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if (StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            throw new MyException(203, "token过期");
        }
        return true;
    }

    /**
     * 根据token字符串获取会员id
     *
     * @param
     * @return
     */
    public static String getMemberIdByJwtToken(String token, String s) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String) claims.get(s);
    }

}
