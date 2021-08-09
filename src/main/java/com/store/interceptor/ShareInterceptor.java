package com.store.interceptor;

import com.store.entity.Catalog;
import com.store.repository.CatalogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class ShareInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    CatalogDao catalogDao;
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        List<Catalog> list = catalogDao.findAll();
        //request.setAttribute("catalog",list);
        modelAndView.addObject("catalog",list);
    }
}
