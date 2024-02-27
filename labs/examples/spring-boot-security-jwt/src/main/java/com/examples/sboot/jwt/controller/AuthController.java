package com.examples.sboot.jwt.controller;

import com.examples.sboot.jwt.model.LoginRequest;
import com.examples.sboot.jwt.model.LoginResponse;
import com.examples.sboot.jwt.security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JwtIssuer jwtIssuer;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        var token = jwtIssuer.issue(JwtIssuer.Request.builder().userId(1L).email("test@test.com").roles(List.of("USER")).build());
        LoginResponse response = LoginResponse.builder().token(token).build();
        return  response;
    }
}
