package com.stylefeng.guns.rest.config;

import brave.spring.beans.TracingFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.okhttp3.OkHttpSender;

/**
 * zipkin 配置
 */
@Slf4j
@Configuration
public class TraceConfig {

    @Bean(name = "tracing")
    public TracingFactoryBean getTracingBean() {
        log.debug("TraceConfig#getTracingBean");
        TracingFactoryBean tracingFactoryBean = new TracingFactoryBean();
        tracingFactoryBean.setLocalServiceName("gateway");
        tracingFactoryBean.setSpanReporter(
                AsyncReporter.create(OkHttpSender.create("http://118.126.111.144:9411/api/v2/spans")));
        log.debug("TraceConfig#getTracingBean="+tracingFactoryBean);
        return tracingFactoryBean;
    }

}
