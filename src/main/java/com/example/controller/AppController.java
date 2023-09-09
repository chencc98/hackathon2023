package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
    
    @RequestMapping("")
    public List<String> list() {
        List<String> list = new ArrayList<>();
        list.add("aaaaaa");
        list.add("aaaaaa");
        list.add("bbbb");
        list.add("hhhh");
        return list;
    }
}
