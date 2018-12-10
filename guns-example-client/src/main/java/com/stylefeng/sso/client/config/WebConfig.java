package com.stylefeng.sso.client.config;

import com.stylefeng.sso.plugin.api.AuthApi;
import com.stylefeng.sso.plugin.cache.ClientCache;
import com.stylefeng.sso.plugin.interceptor.SsoClientInterceptor;
import com.stylefeng.sso.plugin.properties.SsoProperties;
import com.stylefeng.sso.plugin.remote.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author fengshuonan
 * @Date 2018/8/31 上午11:21
 */
@ControllerAdvice
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthApi authApi;

    @Autowired
    private ClientCache clientCache;

    /**
     * 配置sso
     */
    @Bean
    @ConfigurationProperties(prefix = SsoProperties.BEETLCONF_PREFIX)
    public SsoProperties ssoProperties() {
        return new SsoProperties();
    }

    @Bean
    public RemoteService remoteService() {
        return new RemoteService(restTemplate, ssoProperties());
    }

    /**
     * 增加对rest api鉴权的spring mvc拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                new SsoClientInterceptor(ssoProperties(), remoteService(), clientCache, authApi))
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**");
    }
}
