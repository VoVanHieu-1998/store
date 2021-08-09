package com.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

@Service
public class CookieService {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
    public Cookie create(String name,String value ,int days){
        //Mã hóa giá trị cookie getEncoder
        String encodeValue = Base64.getEncoder().encodeToString(value.getBytes());
        Cookie cookie = new Cookie(name,encodeValue);
        //set thời gian cho cookie tính theo giây
        cookie.setMaxAge(days*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return cookie;
    }
    public Cookie read(String name){
        //Gte hết cookie lên duyệt kiểm tra xem có cookie đó hay ko
        Cookie[] cookies = request.getCookies();
        if (cookies != null ){
            for (Cookie cookie : cookies){
                if(cookie.getName().equalsIgnoreCase(name)){
                    //Giải mã byte mã hóa getDecoder
                    String deCoderValue = new String(Base64.getDecoder().decode(cookie.getValue()));
                    cookie.setValue(deCoderValue);
                    return cookie;
                }
            }
        }
        return null;
    }
    public void delete(String name){
        this.create(name,"",0);
    }
}
