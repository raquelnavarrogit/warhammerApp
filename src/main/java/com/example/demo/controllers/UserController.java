package com.example.demo.controllers;

import com.example.demo.facades.UserFacade;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserFacade userFacade;

    @PostMapping("/login")
    public Boolean login(String email, String password){
        return userFacade.login(email, password); //this needs more development. All the security logic is missing.
    }



}
