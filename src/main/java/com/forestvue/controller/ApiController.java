package com.forestvue.controller;

import com.forestvue.domain.MemberListDTO;
import com.forestvue.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/**")
public class ApiController {

    @Autowired
    MemberService memberService;

    @RequestMapping(path = "list")
    @ResponseBody
    public MemberListDTO list(){
        return memberService.getUsers();
    }

}
