package com.example.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

public class MyUtil {
    public static boolean isUserLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            return false;
        }
        String user = (String)session.getAttribute(Constant.LOGIN_EMAIL_KEY);
        if (StringUtils.hasText(user)) {
            return true;
        }
        return false;
    }

    public static String getUserEmail(HttpServletRequest request) {
        if (isUserLogin(request)) {
            return (String)request.getSession().getAttribute(Constant.LOGIN_EMAIL_KEY);
        }
        return "";
    }
}
