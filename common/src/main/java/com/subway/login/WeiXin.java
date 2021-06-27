package com.subway.login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.subway.entity.vo.Template;
import com.subway.exception.MyException;
import com.subway.result.ResultCode;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.net.URI;

public class WeiXin {

    public static String getSessionKeyOrOpenId(String code) throws JSONException {
        //微信端登录code
        String wxCode = code;
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+WeiXinUtil.APPID+"&secret="+WeiXinUtil.SECRET+"&js_code="+code+"&grant_type=authorization_code";

        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;

        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();

            // 创建http GET请求login
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    public static String getAccessToken(){
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+WeiXinUtil.APPID+"&secret="+WeiXinUtil.SECRET;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;

        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();

            // 创建http GET请求login
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
            System.out.println(resultString);
            JSONObject jsonObject = new JSONObject(resultString);
            String accessToken = (String)jsonObject.get("access_token");
            System.out.println(accessToken);
            return accessToken;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ResultCode.ERROR,"获取accessToken失败");
        }
    }

    public static String send(Template template){
        System.out.println(template.getData());
        String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token="+getAccessToken();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;

        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();

            // 创建http GET请求login
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setHeader("Content-Type","application/json;charset=utf-8");

            StringEntity stringEntity = new StringEntity(template.toString(),"UTF-8");
            httpPost.setEntity(stringEntity);

            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(resultString);
            }
            return resultString;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ResultCode.ERROR,"发送失败");
        }
    }

}