package com.yeternal.ureport2.config;

import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.Servlet;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.yeternal.ureport2.config
 * @description:
 * @author: eternallove
 * @date: Created in 2018/11/28 22:41
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: eternallove
 */

@ImportResource("classpath:ureport-console-context.xml")
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "com.yeternal.ureport2")
public class UreportConfig {

    @Bean
    public ServletRegistrationBean<Servlet> buildUreportServlet() {
        return new ServletRegistrationBean<>(new UReportServlet(), "/ureport/*");
    }

}
