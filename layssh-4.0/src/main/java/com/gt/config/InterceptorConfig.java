package com.gt.config;

import com.gt.interceptor.*;
import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

import java.util.*;

/**
 * 拦截器配置
 *
 * @Auther:herun
 * @Date: 2018/9/11 17:18
 * @Description:
 */
@SpringBootConfiguration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    public SessionInterceptor sessionInterceptor() {
        return new SessionInterceptor();
    }

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    public CacheInterceptor cacheInterceptor() {
        return new CacheInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(cacheInterceptor()).addPathPatterns("/**").excludePathPatterns(Arrays.asList("/**/*.*"));

        registry.addInterceptor(new EncodingInterceptor()).addPathPatterns("/**").excludePathPatterns(Arrays.asList("/**/*.*"));

        registry.addInterceptor(sessionInterceptor()).addPathPatterns("/**").excludePathPatterns(Arrays.asList("/**/*.*"));

        registry.addInterceptor(authInterceptor()).addPathPatterns("/**").excludePathPatterns(Arrays.asList("/**/*.*"));


    }

    /**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css").addResourceLocations("/**");
        registry.addResourceHandler("/plugins").addResourceLocations("/**");
        registry.addResourceHandler("/js").addResourceLocations("/**");
        super.addResourceHandlers(registry);
    }


}
