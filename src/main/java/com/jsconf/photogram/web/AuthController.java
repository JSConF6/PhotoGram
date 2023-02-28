package com.jsconf.photogram.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 1.IoC 2.파일을 리턴하는 컨트롤러
public class AuthController {

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    // 회원가입버튼 -> /auth/signup -> /auth/signin
    // 회원가입버튼X
    // CSRF 토큰이란?
    @PostMapping("/auth/signup")
    public String signup() {
        System.out.println("signup 실행됨");
        return "auth/signin";
    }
}
