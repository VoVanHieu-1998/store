package com.store.config;

import com.store.interceptor.AuthorizeInterceptor;
import com.store.interceptor.ShareInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
    @Autowired
    ShareInterceptor shareInterceptor;
    @Autowired
    AuthorizeInterceptor authorizeInterceptor;

    //Tiêm list catalog vào aside xài chung.Vì nếu mà viết từng list catalog trong các controller
    //thì sẽ dư thừa .Nên là tiêm vào đây để xài chung
    //gọi đến bất cứ action nào thì interceptor cũng chạy
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(shareInterceptor).addPathPatterns("/*");
//        registry.addInterceptor(authorizeInterceptor)
//                .addPathPatterns("/user/changePW","/user/logout","/user/edit","/order/*");
//
//    }
}
