package com.example.demo.controllers;

import com.example.demo.dtos.RegisterDto;
import com.example.demo.facades.UserFacade;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserFacade userFacade;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDto dto) {
        userFacade.registerUser(dto);
        return ResponseEntity.ok("User registered successfully.");
    }



}
