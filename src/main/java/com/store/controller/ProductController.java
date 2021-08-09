package com.store.controller;

import com.store.entity.*;
import com.store.service.CatalogService;
import com.store.service.CookieService;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ProductController {
    @Autowired
    CookieService cookieService;
    @Autowired
    CatalogService catalogService;
    @Autowired
    ProductService productService;
    @RequestMapping("/product/list-by-catalog/{id}")
    public String listProductByCatalog(@PathVariable int id, ModelMap modelMap){
        Catalog catalog = catalogService.findById(id);
        Set<Product> productSet = catalog.getListproduct();
        modelMap.addAttribute("catalog",catalogService.findAll());
        modelMap.addAttribute("productSet",productSet);
        return "product/list";
    }
    @RequestMapping(value = "/product/list-by-keywords",method = RequestMethod.POST)
    public String listProductByKeyWords(@RequestParam String keywords, ModelMap modelMap){
        List<Product> list = catalogService.findByKeyWords(keywords);
        modelMap.addAttribute("catalog",catalogService.findAll());

        for (Product p: list) {
            p.setImageArr();
            modelMap.addAttribute("productSet",list);
        }
        return "product/list";
    }
    @RequestMapping("/product/detail/{id}")
    public String listProductDetailByProduct(@PathVariable Integer id, ModelMap modelMap){
        Product product = productService.findById(id);
        modelMap.addAttribute("product",product);
        // Tăng số lần xem
        product.setViewCount(product.getViewCount() +1);
        productService.update(product);
        //Hàng cùng laoij
        Catalog catalog = catalogService.findById(product.getCatalog().getCatalogId());
        Set<Product> productSet = catalog.getListproduct();
        //Thông số
        Set<ProductDetail> productDetails = product.getProductDetails();
        ArrayList<ProductDetail> arrDetail = new ArrayList<>();
        Spec spec = new Spec();
        for (ProductDetail detail: productDetails) {
            arrDetail.add(detail);
            spec = detail.getSpec_proDetail();
        }
        // Hàng yêu thích khi click ajax vào icon ngôi sao
        Cookie cookie = cookieService.read("addToFavorite");
        if(cookie != null){
            String ids = cookie.getValue();
            List<Product> favo = productService.findByIds(ids);
            modelMap.addAttribute("favo", favo);
        }
        //Hàng đã xem khi nhấn vào mặt hàng đó lấy ra id của mặt hàng đó
        Cookie viewed = cookieService.read("viewed");
        String value = id.toString();
        if(viewed != null){
            value = viewed.getValue();
            value += ","+id.toString();

        }
        cookieService.create("viewed",value,10);
        List<Product> views = productService.findByIds(value);
        modelMap.addAttribute("views", views);

        modelMap.addAttribute("catalog",catalogService.findAll());
        modelMap.addAttribute("productSet",productSet);
        modelMap.addAttribute("spec", spec);
        return "product/detail";
    }
    @RequestMapping("/product/spec/{id}")
    public String listProductBySpec(@PathVariable int id, ModelMap modelMap){
        List<Product> productSet = productService.findBySpecial(id);
        modelMap.addAttribute("catalog",catalogService.findAll());
        modelMap.addAttribute("productSet",productSet);
        return "product/list";
    }



}
