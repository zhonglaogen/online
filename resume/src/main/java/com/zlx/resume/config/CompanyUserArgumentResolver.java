package com.zlx.resume.config;

import com.alibaba.druid.util.StringUtils;
import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.User1;
import com.zlx.resume.service.CompanyService;
import com.zlx.resume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CompanyUserArgumentResolver implements HandlerMethodArgumentResolver {




    @Autowired
    CompanyService userService;

    /**
     * 当参数类型为User才做处理
     *
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //获取参数类型
        Class<?> clazz = methodParameter.getParameterType();
        return clazz == Companyuser.class;
    }

    /**
     * 思路：先获取到已有参数HttpServletRequest，从中获取到token，再用token作为key从redis拿到User，而HttpServletResponse作用是为了延迟有效期
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);

        //用户传来参数
        String paramToken = request.getParameter(CompanyService.COOKIE_NAME_TOKEN);
        //request传来的cookie
        String cookieToken = getCookieValue(request, CompanyService.COOKIE_NAME_TOKEN);
        if (StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
            return null;
        }
        String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
        return userService.getByToken(response, token);
    }

    //遍历所有cookie，找到需要的那个cookie
    private String getCookieValue(HttpServletRequest request, String cookiName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length <= 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookiName)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
