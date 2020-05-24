package com.xnote.manage.core.interceptor;

import com.xnote.manage.modules.login.bean.LoginAdmin;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @DESC:
 * @ClassName: LoginInterceptor
 * @Author: xiaojundi_xx
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        LoginAdmin loginAdmin = (LoginAdmin) request.getSession().getAttribute("loginAdmin");
        if (ObjectUtils.isEmpty(loginAdmin))
        {
            response.sendRedirect(request.getContextPath()+"/load/login");
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView)
    {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception
    {

    }
}
