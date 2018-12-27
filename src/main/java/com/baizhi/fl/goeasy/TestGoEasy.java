package com.baizhi.fl.goeasy;

import io.goeasy.GoEasy;

/**
 * Created by lenovo on 2018/7/11.
 */
public class TestGoEasy {
    //基于 api 创建 goeasy
    public static void main(String[] args) {
        GoEasy goEasy = new GoEasy("rest-hangzhou.goeasy.io", "-34f16228e0434f8ea2f6d95e98ae8e06");
        goEasy.publish("fl_channel", "大家好，goeasy 消息推送666！");

    }
}