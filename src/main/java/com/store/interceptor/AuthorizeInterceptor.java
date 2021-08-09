package com.store.interceptor;

import com.store.entity.Users;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        if(users == null) {
            session.setAttribute("back-url",request.getRequestURI());
            response.sendRedirect("/user/login");
            return false;
        }
        return true;
    }
}
