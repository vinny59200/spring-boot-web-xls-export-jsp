package com.vv.configuration;

import com.vv.web.ExcelExportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LegacyServletConfig {

    @Bean
    public ServletRegistrationBean<ExcelExportServlet> exportServlet() {
        ServletRegistrationBean<ExcelExportServlet> srb =
                new ServletRegistrationBean<>(new ExcelExportServlet(), "/export");
        srb.setName("ExcelExportServlet");
        return srb;
    }
}
