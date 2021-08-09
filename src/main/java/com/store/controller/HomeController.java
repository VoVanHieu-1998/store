package com.store.controller;

import com.store.entity.Catalog;
import com.store.repository.CatalogDao;
import com.store.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CatalogService catalogService;
    @RequestMapping("/")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("catalog",catalogService.findAll());
        return "home/index";
    }
    @RequestMapping("/about")
    public String about(ModelMap modelMap){
        modelMap.addAttribute("catalog",catalogService.findAll());
        return "home/about";
    }
    @RequestMapping("/contact")
    public String contact(ModelMap modelMap){
        modelMap.addAttribute("catalog",catalogService.findAll());
        return "home/contact";
    }
    @RequestMapping("/feedback")
    public String feedback(ModelMap modelMap){
        modelMap.addAttribute("catalog",catalogService.findAll());
        return "home/feedback";
    }

}
