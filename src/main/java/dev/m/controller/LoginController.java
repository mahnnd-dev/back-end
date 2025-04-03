package dev.m.controller;

import dev.m.obj.ResponseApi;
import dev.m.obj.LoginRequest;
import dev.m.service.impl.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/api/auth")
public class LoginController {
    final LoginService loginService;

    @Autowired
    public LoginController(LoginService service) {
        this.loginService = service;
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseApi login(@RequestBody LoginRequest request) {
        return loginService.findByUsername(request);
    }

    @ResponseBody
    @PostMapping("/logout")
    public ResponseApi logout(@RequestBody LoginRequest request) {
        return loginService.findByUsername(request);
    }
}