package dev.m.controller;

import dev.m.obj.ResponseApi;
import dev.m.obj.SignInRequest;
import dev.m.service.impl.AuthenticateService;
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
public class AuthenticateController {
    final AuthenticateService authenticateService;

    @Autowired
    public AuthenticateController(AuthenticateService service) {
        this.authenticateService = service;
    }

    @ResponseBody
    @PostMapping("/signin")
    public ResponseApi signIn(@RequestBody SignInRequest request) {
        return authenticateService.findByUsername(request);
    }

    @ResponseBody
    @PostMapping("/signup")
    public ResponseApi signUp(@RequestBody SignInRequest request) {
        return authenticateService.findByUsername(request);
    }
}