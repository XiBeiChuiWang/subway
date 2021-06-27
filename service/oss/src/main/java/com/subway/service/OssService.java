package com.subway.service;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.subway.entity.vo.StS;
import com.subway.exception.MyException;
import com.subway.result.ResultCode;
import com.subway.thread.ThreadUtil;
import com.subway.utils.Oss_Util;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OssService {

    public String upload(MultipartFile file){
        // 工具类获取值
        String endpoint = Oss_Util.END_POIND;
        String accessKeyId = Oss_Util.ACCESS_KEY_ID;
        String accessKeySecret = Oss_Util.ACCESS_KEY_SECRET;
        String bucketName = Oss_Util.BUCKET_NAME;

        try {
            // 创建OSS实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            //获取上传文件输入流
            InputStream inputStream = file.getInputStream();
            //获取文件名称
            String fileName = file.getOriginalFilename();

            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            fileName = uuid + fileName;

            String datePath = new DateTime().toString("yyyy/MM/dd");
            //拼接
            //  2019/11/12/ewtqr313401.jpg
            fileName = datePath+"/"+fileName;


            ossClient.putObject(bucketName,fileName , inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();

            //把上传之后文件路径返回
            //需要把上传到阿里云oss路径手动拼接出来
            //  https://edu-guli-1010.oss-cn-beijing.aliyuncs.com/01.jpg
            String url = "https://"+bucketName+"."+endpoint+"/"+fileName;
            return url;
        }catch(Exception e) {
            e.printStackTrace();
            throw new MyException(ResultCode.ERROR,"网络出现错误",null);
        }
    }

    public String uploadFileAvatar(MultipartFile file) {
        return upload(file);
    }

    public List<String> uploadFileAvatar(MultipartFile[] files) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(files.length);
        AtomicInteger atomicInteger = new AtomicInteger(-1);
        ArrayList<String> list = new ArrayList<>(10);
        long start = System.currentTimeMillis();

        for (int i = 0;i < files.length;i++){
            int finalI = atomicInteger.incrementAndGet();
            ThreadUtil.execute(()->{
                String upload = upload(files[finalI]);
                System.out.println(finalI + " : "+ upload);
                concurrentHashMap.put(String.valueOf(finalI),upload);
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await(30,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new MyException(ResultCode.ERROR,"网络出现错误",null);
        }
        for (int i = 0;i < files.length;i++){
            list.add(concurrentHashMap.get(String.valueOf(i)));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return list;
    }

    public HashMap<String,Object> uploadFileAvatar1(MultipartFile[] file) {
        HashMap<String, Object> stringStringHashMap = new HashMap<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i < file.length;i++){
            String upload = upload(file[i]);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return stringStringHashMap;
    }

    public StS sts() {
        // STS接入地址，例如sts.cn-hangzhou.aliyuncs.com。
        String endpoint = Oss_Util.END_POIND;
        // 填写步骤1生成的访问密钥AccessKey ID和AccessKey Secret。
        String AccessKeyId = Oss_Util.ACCESS_KEY_ID;
        String accessKeySecret = Oss_Util.ACCESS_KEY_SECRET;
        // 填写步骤3获取的角色ARN。
        String roleArn = Oss_Util.ROLE_ARN;
        // 标识临时访问凭证的名称.
        String roleSessionName = "subway";
        // 以下Policy用于限制仅允许使用临时访问凭证向目标存储空间examplebucket上传文件。
        // 临时访问凭证最后获得的权限是步骤4设置的角色权限和该Policy设置权限的交集，即仅允许将文件上传至目标存储空间examplebucket下的exampledir目录。
        String policy = "{\n" +
                "    \"Version\": \"1\",\n" +
                "    \"Statement\": [\n" +
                "        {\n" +
                "            \"Effect\": \"Allow\",\n" +
                "            \"Action\": [\n" +
                "                \"oss:PutObject\"\n" +
                "            ],\n" +
                "            \"Resource\": [\n" +
                "                \"acs:oss:*:*:zhang-xiaolan/\",\n" +
                "                \"acs:oss:*:*:zhang-xiaolan/*\"\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        try {
            // 添加endpoint。
            DefaultProfile.addEndpoint("", "", "Sts", endpoint);
            // 构造default profile。
            IClientProfile profile = DefaultProfile.getProfile("", AccessKeyId, accessKeySecret);
            // 构造client。
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
            request.setPolicy(policy); // 如果policy为空，则用户将获得该角色下所有权限。
            request.setDurationSeconds(3600L); // 设置临时访问凭证的有效时间为3600秒。
            final AssumeRoleResponse response = client.getAcsResponse(request);
//            System.out.println("Expiration: " + response.getCredentials().getExpiration());
//            System.out.println("Access Key Id: " + response.getCredentials().getAccessKeyId());
//            System.out.println("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
//            System.out.println("Security Token: " + response.getCredentials().getSecurityToken());
//            System.out.println("RequestId: " + response.getRequestId());
            StS stS = new StS(response.getCredentials().getExpiration(), response.getCredentials().getAccessKeyId(),
                    response.getCredentials().getAccessKeySecret(), response.getCredentials().getSecurityToken(),
                    response.getRequestId()
            );
            return stS;
        } catch (ClientException e) {
            throw new MyException(ResultCode.ERROR,"错误");
        }
    }
}
