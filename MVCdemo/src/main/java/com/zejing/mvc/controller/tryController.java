package com.zejing.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class tryController {

    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping("/target")
    public String target() {

        return "target";
    }
}
