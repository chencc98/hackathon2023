package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.util.Constant;
import com.example.util.MyUtil;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @GetMapping("")
    public String index(HttpServletRequest request, Model model) {
        boolean isUserIn = MyUtil.isUserLogin(request);
        String userEmail = MyUtil.getUserEmail(request);
        String userStatus = "NotLogin";
        if (isUserIn) {
            userStatus = "Login";
        }

        model.addAttribute("isUserIn", isUserIn);
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("userStatus", userStatus);
        return "chat_index";
    }

    @GetMapping("/start")
    @ResponseBody
    public String startSession(@RequestParam String userEmail, HttpServletRequest request) {
        if (!StringUtils.hasText(userEmail)) {
            throw new RuntimeException("userEmail is empty");
        }
        request.getSession().setAttribute(Constant.LOGIN_EMAIL_KEY, userEmail);
        return "Login";
    }

    @GetMapping("/stop")
    @ResponseBody
    public String stopSession(HttpServletRequest request) {
        
        request.getSession().invalidate();
        return "Logout";
    }
    
}
