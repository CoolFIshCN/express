package com.express.config;

import com.express.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@EnableWebMvc
public class InterceptorConfig implements WebMvcConfigurer {

    private AuthenticationInterceptor authenticationInterceptor;
    @Bean
    public AuthenticationInterceptor getAuthInterceptor() {
        return new AuthenticationInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthInterceptor())
                .addPathPatterns("/**")   // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
                .excludePathPatterns("/login")
                .excludePathPatterns("/swagger-resources/**"
                        , "/webjars/**", "/v2/**"
                        , "/swagger-ui.html/**","/swagger/**"
                        ,"/swagger-ui.html","/api-docs/**"
                ,"/error");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //将templates目录下的CSS、JS文件映射为静态资源，防止Spring把这些资源识别成thymeleaf模版
        registry.addResourceHandler("/templates/**.js").addResourceLocations("classpath:/templates/");
        registry.addResourceHandler("/templates/**.css").addResourceLocations("classpath:/templates/");
        //其他静态资源
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //swagger增加url映射
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
