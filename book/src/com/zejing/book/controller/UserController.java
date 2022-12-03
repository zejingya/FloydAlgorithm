package com.zejing.book.controller;

import com.zejing.book.pojo.User;
import com.zejing.book.service.UserService;

import javax.servlet.http.HttpSession;

public class UserController {

    private UserService userService;

    public String login(String uname, String pwd, HttpSession session) {

        User user = userService.login(uname, pwd);

        if (user != null) {
            session.setAttribute("currUser",user);
            return "redirect:book.do";
        }
        return "user/login";

    }
}
