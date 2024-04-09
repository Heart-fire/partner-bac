package com.yupi.common;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 常量类，读取配置文件application.properties中的配置
 *
 */
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class ConstantPropertiesUtil implements InitializingBean {

    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME;
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;//"https://oss-cn-hangzhou.aliyuncs.com";
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;//"LTAI5t72omXPbzhdH25osEt6";
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;//"btuEfZ8pGHuFBCNxMdsAFjExAqtSk3";
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;//"wbe-tilas";

    @Override
    public void afterPropertiesSet() throws Exception {
        KEY_ID = this.accessKeyId;
        KEY_SECRET = this.accessKeySecret;
        END_POINT = this.endpoint;
        BUCKET_NAME = this.bucketName;
    }

}
