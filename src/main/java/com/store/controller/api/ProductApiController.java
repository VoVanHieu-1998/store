package com.store.controller.api;

import com.store.model.MailInfo;
import com.store.service.CartSession;
import com.store.service.CookieService;
import com.store.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductApiController {
    @Autowired
    CookieService cookieService;
    @Autowired
    MailService mailService;
    @Autowired
    CartSession cartSession;

    @RequestMapping("/product/addToFavorite/{id}")
    @ResponseBody
    public boolean addToFavorite(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) {
        Cookie favo = cookieService.read("addToFavorite");
        String value = id.toString();
        if (favo != null) {
            value = favo.getValue();
            //value không chứa id
            if (!value.contains(id.toString())) {
                //truyền thêm id cho value
                value += "," + id.toString();
            } else {
                return false;
            }
        }
        cookieService.create("addToFavorite", value, 30);
        return true;
    }

    //    @RequestMapping("/product/send-to-friend")
//    @ResponseBody
//    public boolean sendToFriend(@RequestParam String id,@RequestParam String emailFrom,@RequestParam String emailTo,@RequestParam String comment){
//        //Send mail
//        //Email send có thể lấy từ Session khi User đăng nhập vào hệ thống
//        MailInfo info = new MailInfo();
//        info.setTo(emailTo);
//        info.setSubject("Thông tin hàng hóa");
//        info.setFrom(emailFrom);
//        info.setBody(comment);
//        try {
//            mailService.send(info);
//            return true;
//        }catch (Exception e){
//            return false;
//
//        }
//    }
    @RequestMapping("/product/send-to-friend")
    @ResponseBody
    public boolean sendToFriend(MailInfo info, HttpServletRequest request) {
        //Toàn bộ data bên ajax vào trong bean MailInfo: Do tham số trùng với tên thuộc tính
        //Send mail
        //Email send có thể lấy từ Session khi User đăng nhập vào hệ thống
        //request.getRequestURI().toString() : Đường dẫn hiện tại khi gọi ajax send mail
        info.setSubject("Thông tin hàng hóa");
        try {
            String id = request.getParameter("id");//Có thể dùng @RequestParam String id để nhận id
            // Get ra link hiện tại thay thế bằng detail/{id}
//            String link = request.getRequestURI().
//                    toString().replace("send-to-friend","detail/"+ id);
            String link = "http://localhost:8080/product/detail/" + id;
            info.setBody(info.getBody() + "<hr> <a href='" + link + "'> Xem chi tiết...</a>");
            mailService.send(info);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }


}
