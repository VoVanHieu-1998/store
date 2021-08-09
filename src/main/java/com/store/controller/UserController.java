package com.store.controller;

import com.store.entity.Users;
import com.store.model.MailInfo;
import com.store.service.CatalogService;
import com.store.service.CookieService;
import com.store.service.MailService;
import com.store.service.UserService;
import com.store.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CatalogService catalogService;
    @Autowired
    HttpSession session;
    @Autowired
    CookieService cookieService;
    @Autowired
    ServletContext app;
    @Autowired
    MailService mailService;
    @Autowired
    UserValidator userValidator;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        if (binder.getTarget() == null) {
            return;
        }
        if (binder.getTarget().getClass() == Users.class) {
            binder.setValidator(userValidator);
        }
    }

    @GetMapping("/user/login")
    public String login(ModelMap modelMap) {
        modelMap.addAttribute("catalog", catalogService.findAll());
        Cookie user = cookieService.read("user");
        Cookie pass = cookieService.read("password");
        if (user != null) {
            modelMap.addAttribute("username", user.getValue());
            modelMap.addAttribute("password", pass.getValue());
        }
        return "user/login";
    }

    @PostMapping("/user/login")
    public String login(Model model,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam(value = "rm", defaultValue = "false") boolean rm) {
        Users users = userService.findByUsername(username);
        if (users == null) {
            model.addAttribute("message", "Invalid username!");
        } else if (!password.equals(users.getPassword())) {
            model.addAttribute("message", "Invalid password!");
        } else if (users.getActivated() == 0) {
            model.addAttribute("message", "Your account is Inactivated!");
        } else {
            model.addAttribute("message", "Login success!");
            session.setAttribute("user", users);
            //ghi nhớ tài khoản bằng cookie
            if (rm == true) {
                cookieService.create("user", users.getUsername(), 30);
                cookieService.create("password", users.getPassword(), 30);
            } else {
                cookieService.delete("user");
                cookieService.delete("password");
            }
        }
        return "user/login";
    }

    @RequestMapping("/user/logout")
    public String logout(ModelMap modelMap) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping("/user/register")
    public String register(Model model) {
        Users users = new Users();
        model.addAttribute("user", users);
        return "user/register";
    }

    @PostMapping("/user/register")
    public String register(Model model, @ModelAttribute("user") Users user,
                           @RequestParam("photoFile") MultipartFile photo,
                           BindingResult error) throws IOException, MessagingException {
        userValidator.validate(user, error);
        if (error.hasErrors()) {
            if (photo.isEmpty()) {
                user.setPhoto("user.png");
            } else {
                //thư mục mà ta để file trong đó
                String path = "D:/springboot-security/login/src/main/webapp/resources/img/user/";
                String dir = app.getRealPath("/resources/img/user");
                //photo.getOriginalFilename() tên file gốc upload lên
                File file = new File(path, photo.getOriginalFilename());
                photo.transferTo(file);
                user.setPhoto(file.getName());
            }
            return "user/register";
        }


        user.setActivated(0);
        user.setLevel("USER");
        int id = userService.create(user);
        System.out.println(id + "tạo tài khoan thành công");
        model.addAttribute("message", "Register success");
        String form = "hieu25102015aa@gmail.com";
        String link = "http://localhost:8080/product/active/" + user.getUsername();
        String body = "Click <a href='" + link + "'> Xem chi tiết...</a>";
        MailInfo info = new MailInfo(form, user.getEmail(), "Hello", body);
        //mailService.send(info);
        return "user/register";
    }

    @GetMapping("/user/active/{username}")
    public String active(Model model, @PathVariable String username) {
        Users users = userService.findByUsername(username);
        users.setActivated(1);
        userService.update(users);
        model.addAttribute("user", users);
        return "redirect:/user/login";
    }

    @GetMapping("/user/forgotPW")
    public String forgotPW(Model model) {
        return "user/forgot";
    }

    @PostMapping("/user/forgotPW")
    public String forgotPW(Model model, @RequestParam("username") String username,
                           @RequestParam("email") String email) throws MessagingException {
        Users users = userService.findByUsername(username);
        if (users == null) {
            model.addAttribute("message", "Username invalid!");
        } else if (!email.equalsIgnoreCase(users.getEmail())) {
            model.addAttribute("message", "Email invalid!");
        } else {
            String form = "hieu25102015aa@gmail.com";
            String body = "Your password is " + users.getPassword();
            MailInfo info = new MailInfo(form, users.getEmail(), "Forgot password", body);
            mailService.send(info);
            model.addAttribute("message", "Your password was send to email!");
        }
        model.addAttribute("user", users);
        return "redirect:/user/login";
    }

    @GetMapping("/user/changePW")
    public String changePW(Model model) {
        return "user/changePW";
    }

    @PostMapping("/user/changePW")
    public String changePW(Model model, @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("pw1") String pw1,
                           @RequestParam("pw2") String pw2) {
        if (!pw1.equals(pw2)) {
            model.addAttribute("message", "Confirm password is not match");
        } else {
            Users users = userService.findByUsername(username);
            if (users == null) {
                model.addAttribute("message", "Username invalid!");
            } else if (!password.equals(users.getPassword())) {
                model.addAttribute("message", "Password invalid!");
            } else {
                users.setPassword(pw1);
                userService.update(users);
                model.addAttribute("message", "Change password successfully");
            }
        }

        return "redirect:/user/login";
    }

    @GetMapping("/user/edit")
    public String edit(Model model) {
        Users users = (Users) session.getAttribute("user");
        model.addAttribute("user", users);
        return "user/edit";
    }

    @PostMapping("/user/edit")
    public String edit(Model model, @ModelAttribute("user") Users user,
                       @RequestParam("photoFile") MultipartFile photo) throws IOException {

        if (!photo.isEmpty()) {
            //thư mục mà ta để file trong đó
            String path = "D:/springboot-security/login/src/main/webapp/resources/img/user/";
            String dir = app.getRealPath("/resources/img/user");
            //photo.getOriginalFilename() tên file gốc upload lên
            File file = new File(path, photo.getOriginalFilename());
            photo.transferTo(file);
            user.setPhoto(file.getName());
        }
        Users u = userService.findByUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setFullName(user.getFullName());
        u.setPhoneNumber(user.getPhoneNumber());
        u.setAddress(user.getAddress());
        u.setPhoto(user.getPhoto());
        userService.update(u);
        session.setAttribute("user", u);
        model.addAttribute("message", "Edit user successfully");
        return "user/edit";
    }
}
