package org.xujin.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xujin
 * @package-name org.xujin.springboot.component
 * @createtime 2020-02-26 16:22
 */
/*
 *登录检查
 */
public class LoginHandlerIntercepor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object loginUser = httpServletRequest.getSession().getAttribute("loginUser");
        if (loginUser != null){
            return true;
        }
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
