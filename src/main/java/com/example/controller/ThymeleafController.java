package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/html")
public class ThymeleafController {
    
    @RequestMapping("/hi")
    public String hello(Model model, @RequestParam String name) {
        if (StringUtils.isEmpty(name)) {
            name = "defaultName";
        }
        model.addAttribute("hello", name);
        return "hello";
    } 
}
