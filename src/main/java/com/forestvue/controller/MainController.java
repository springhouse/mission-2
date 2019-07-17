package com.forestvue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    @GetMapping(value="/")
    public String index(){
        return "index";
    }
    @GetMapping(value = "/ajaxLogin")
    public String login(){
        return "ajaxLogin";
    }
    @GetMapping(value = "/register")
    public String register(){
        return "register";
    }
    @RequestMapping(value="/auth-failure", produces = "application/json")
    @ResponseBody
    public Object failed(){
        Map<String, String> m = new HashMap<>();
        m.put("auth", "failed");
        return m;
    }
    @GetMapping(value="/auth-success", produces = "application/json")
    @ResponseBody
    public Object success(){
        Map<String, String> m = new HashMap<>();
        m.put("auth", "success");
        return m;
    }
}

