package com.bookcrossing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/FAQ")
    public String faq(){
        return "FAQ";
    }


}
