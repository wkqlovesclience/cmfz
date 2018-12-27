package com.baizhi.fl.fastjson;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;


/**
 * Created by lenovo on 2018/7/5.
 */
@Configuration  //不在入口类写，要声明 这个是全局配置  不然fastjson  不生效
public class CmfzFastJsonConf {
    private FastJsonHttpMessageConverter converter;

    @Bean
    public HttpMessageConverters setFastJsonHttpMessageConverter() {

        //定义一个转换消息的对象
        FastJsonHttpMessageConverter Converter = converter;
        //添加fastjson的配置信息 比如 ：是否要格式化返回的json数据
        com.alibaba.fastjson.support.config.FastJsonConfig fastJsonConfig = new com.alibaba.fastjson.support.config.FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //在转换器中添加配置信息
        Converter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = Converter;
        return new HttpMessageConverters(converter);

    }



}
