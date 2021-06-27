package com.subway;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.google.gson.Gson;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
public class Test {
//    @org.junit.Test
//    public void a(){
//        // STS接入地址，例如sts.cn-hangzhou.aliyuncs.com。
//        String endpoint = "sts.cn-beijing.aliyuncs.com";
//        // 填写步骤1生成的访问密钥AccessKey ID和AccessKey Secret。
//        String AccessKeyId = "LTAI5tCWXzMtrGdpAJnhYFBs";
//        String accessKeySecret = "qfikaorQXURnPZLWUV1egLt7GoFYdE";
//        // 填写步骤3获取的角色ARN。
//        String roleArn = "acs:ram::1523507524044975:role/ramosstest";
//        // 标识临时访问凭证的名称.
//        String roleSessionName = "subway";
//        // 以下Policy用于限制仅允许使用临时访问凭证向目标存储空间examplebucket上传文件。
//        // 临时访问凭证最后获得的权限是步骤4设置的角色权限和该Policy设置权限的交集，即仅允许将文件上传至目标存储空间examplebucket下的exampledir目录。
//        String policy = "{\n" +
//                "    \"Version\": \"1\",\n" +
//                "    \"Statement\": [\n" +
//                "        {\n" +
//                "            \"Effect\": \"Allow\",\n" +
//                "            \"Action\": [\n" +
//                "                \"oss:PutObject\"\n" +
//                "            ],\n" +
//                "            \"Resource\": [\n" +
//                "                \"acs:oss:*:*:zhang-xiaolan/\",\n" +
//                "                \"acs:oss:*:*:zhang-xiaolan/*\"\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}";
//
//
//        try {
//            // 添加endpoint。
//            DefaultProfile.addEndpoint("", "", "Sts", endpoint);
//            // 构造default profile。
//            IClientProfile profile = DefaultProfile.getProfile("", AccessKeyId, accessKeySecret);
//            // 构造client。
//            DefaultAcsClient client = new DefaultAcsClient(profile);
//            final AssumeRoleRequest request = new AssumeRoleRequest();
//            request.setProtocol(ProtocolType.HTTPS);
//            request.setMethod(MethodType.POST);
//            request.setRoleArn(roleArn);
//            request.setRoleSessionName(roleSessionName);
//            request.setPolicy(policy); // 如果policy为空，则用户将获得该角色下所有权限。
//            request.setDurationSeconds(3600L); // 设置临时访问凭证的有效时间为3600秒。
//            final AssumeRoleResponse response = client.getAcsResponse(request);
//            System.out.println("Expiration: " + response.getCredentials().getExpiration());
//            System.out.println("Access Key Id: " + response.getCredentials().getAccessKeyId());
//            System.out.println("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
//            System.out.println("Security Token: " + response.getCredentials().getSecurityToken());
//            System.out.println("RequestId: " + response.getRequestId());
//        } catch (ClientException e) {
//            System.out.println(e);
//            System.out.println("Failed：");
//            System.out.println("Error code: " + e.getErrCode());
//            System.out.println("Error message: " + e.getErrMsg());
//            System.out.println("RequestId: " + e.getRequestId());
//        }
//    }

//    @org.junit.Test
//    public void b() throws ParseException, FileNotFoundException {
//        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
//        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
//// 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//        String accessKeyId = "LTAI5tCWXzMtrGdpAJnhYFBs";
//        String accessKeySecret = "qfikaorQXURnPZLWUV1egLt7GoFYdE";
//// 填写Bucket名称。
//        String bucketName = "zhang-xiaolan";
//// 填写不包含Bucket名称在内的Object完整路径。
//        String objectName = "2021/examplefile1.txt";
//
//// 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//// 填写签名URL的过期时间。
//        Date expiration = DateUtil.parseRfc822Date("Wed, 18 Mar 2022 14:20:00 GMT");
//// 生成签名URL。
//        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, objectName, HttpMethod.PUT);
//// 设置过期时间。
//        request.setExpiration(expiration);
//// 设置ContentType。
//        request.setContentType("application/txt");
//// 添加用户自定义元信息。
//        request.addUserMetadata("author", "aliy");
//// 通过HTTP PUT请求生成签名URL。
//        URL signedUrl = ossClient.generatePresignedUrl(request);
//        System.out.println("signed url for putObject: " + signedUrl);
//
//// 使用签名URL发送请求。
//// 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件。
//        File f = new File("C:\\Users\\wwwe\\Desktop\\examplefile.txt");
//        FileInputStream fin = new FileInputStream(f);
//// 添加PutObject请求头。
//        Map<String, String> customHeaders = new HashMap<String, String>();
//        customHeaders.put("Content-Type", "application/txt");
//        customHeaders.put("x-oss-meta-author", "aliy");
//
//        PutObjectResult result = ossClient.putObject(signedUrl, fin, f.length(), customHeaders);
//
//// 关闭OSSClient。
//        ossClient.shutdown();
//
//    }

    @org.junit.Test
    public void c() throws FileNotFoundException {
//        //构建一个阿里云客户端，用于发起请求。
//        //构建阿里云客户端时需要设置AccessKey ID和AccessKey Secret。
//        DefaultProfile profile = DefaultProfile.getProfile("cn-beijing", "LTAI5tCWXzMtrGdpAJnhYFBs", "qfikaorQXURnPZLWUV1egLt7GoFYdE");
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        //构造请求，设置参数。关于参数含义和设置方法，请参见API参考。
//        AssumeRoleRequest request = new AssumeRoleRequest();
//        request.setRegionId("cn-beijing");
//        request.setRoleArn("acs:ram::1523507524044975:role/ramosstest");
//        request.setRoleSessionName("subway");
//
//        //发起请求，并得到响应。
//        try {
//            AssumeRoleResponse response = client.getAcsResponse(request);
//            System.out.println(new Gson().toJson(response));
//        } catch (ServerException e) {
//            e.printStackTrace();
//        } catch (ClientException e) {
//            System.out.println("ErrCode:" + e.getErrCode());
//            System.out.println("ErrMsg:" + e.getErrMsg());
//            System.out.println("RequestId:" + e.getRequestId());
//        }

        // STS接入地址，例如sts.cn-hangzhou.aliyuncs.com。
        String endpoint = "sts.aliyuncs.com";
        // 填写步骤1生成的访问密钥AccessKey ID和AccessKey Secret。
        String AccessKeyId = "LTAI5tCWXzMtrGdpAJnhYFBs";
        String accessKeySecret = "qfikaorQXURnPZLWUV1egLt7GoFYdE";
        // 填写步骤3获取的角色ARN。
        String roleArn = "acs:ram::1523507524044975:role/ramosstest";
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
            System.out.println("Expiration: " + response.getCredentials().getExpiration());
            System.out.println("Access Key Id: " + response.getCredentials().getAccessKeyId());
            System.out.println("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
            System.out.println("Security Token: " + response.getCredentials().getSecurityToken());
            System.out.println("RequestId: " + response.getRequestId());
        } catch (ClientException e) {
            System.out.println("Failed：");
            System.out.println("Error code: " + e.getErrCode());
            System.out.println("Error message: " + e.getErrMsg());
            System.out.println("RequestId: " + e.getRequestId());

        }

    }


}
