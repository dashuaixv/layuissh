package com.gt;

import com.gt.servlet.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.*;
import org.springframework.boot.web.servlet.*;
import org.springframework.boot.web.servlet.support.*;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.*;

@EnableTransactionManagement
@SpringBootApplication
public class LaysshApplication extends SpringBootServletInitializer {


    /***********配置servlet-开始*********/
    @Bean
    public ServletRegistrationBean quartzInItServlet() {
        return new ServletRegistrationBean(new QuartzInItServlet(), "/QuartzInItServlet");
    }

    @Bean
    public ServletRegistrationBean imageServlet() {
        return new ServletRegistrationBean(new ImageServlet(), "/ImageServlet");
    }

    /***********配置servlet-结束*********/

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(LaysshApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(LaysshApplication.class, args);
    }


}
