package com.zlx.resume.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 使用WebMvcConfigurerAdapter扩展mvc功能，如拦截器，视图解析器,内部功能
 * 无效,又有效了,
 * 和默认的组合使用，调用的时候for循环调用所有
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    /**视图映射
     * 设置首页
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
            WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
                @Override
                public void addViewControllers(ViewControllerRegistry registry) {
                    registry.addViewController("/").setViewName("welcome");
                    registry.addViewController("/index.html").setViewName("welcome");
                    //防止刷新，表单重复提交，重定向页面
//                    registry.addViewController("/main.html").setViewName("dashboard");
                }

            };
        return webMvcConfigurer;
    }

}
