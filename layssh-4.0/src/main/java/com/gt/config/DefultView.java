package com.gt.config;

import org.springframework.core.*;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 配置首页
 * @Auther:herun
 * @Date: 2018/9/7 15:28
 * @Description:
 */
public class DefultView extends WebMvcConfigurerAdapter {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/Login.jsp");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);

    }
}
