package com.stylefeng.sso.client.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * rest模板配置
 *
 * @author fengshuonan
 * @date 2018-08-29-下午4:55
 */
@Configuration
public class RestConfig {

    @Autowired
    private FastJsonHttpMessageConverter fastJsonHttpMessageConverter;

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.messageConverters(fastJsonHttpMessageConverter);
    }

    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder().build();
    }
}
