package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductViewController {

    @GetMapping("/products")
    public String viewProducts() {
        return "products";  // Trả về tên JSP products.jsp
    }
}
