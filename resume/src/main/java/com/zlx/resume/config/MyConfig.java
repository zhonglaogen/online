package com.zlx.resume.config;



import com.zlx.resume.config.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 使用WebMvcConfigurerAdapter扩展mvc功能，如拦截器，视图解析器,内部功能
 * 无效,又有效了,
 * 和默认的组合使用，调用的时候for循环调用所有
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

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

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/*.*");
//    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // addPathPatterns("/**") 表示拦截所有的请求，
//        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
////        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/register");
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/","/do_culogin","/culogin");
//
//    }


}
