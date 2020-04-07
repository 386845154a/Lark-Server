package com.workhub.z.servicechat.config;

import java.util.Arrays;
import java.util.List;

/**
 * @auther: zhuqz
 * @date: 2020/4/2 15:29
 * @description: 在线客服配置
 */
public class OnLineServerConfig {
    //在线客服的id，逗号分隔
    private static final  String ONLINE_SERVER_IDS = "YE016KXb,123457,123458";

    //获取在线客服列表
    public static List<String> getOnlineServerList() {
        return Arrays.asList(ONLINE_SERVER_IDS.split(","));
    }
}