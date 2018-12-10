package com.stylefeng.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * SSO 客户端示例
 *
 * @author stylefeng
 * @Date 2018年2月3日15:34:08
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SsoClientExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoClientExampleApplication.class, args);
    }
}
