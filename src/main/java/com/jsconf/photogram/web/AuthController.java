package com.jsconf.photogram.web;

import com.jsconf.photogram.domain.user.User;
import com.jsconf.photogram.handler.ex.CustomValidationException;
import com.jsconf.photogram.service.AuthService;
import com.jsconf.photogram.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller // 1.IoC 2.파일을 리턴하는 컨트롤러
@RequiredArgsConstructor // final 필드를 DI 할때 사용
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    // 회원가입버튼 -> /auth/signup -> /auth/signin
    // 회원가입버튼 X
    @PostMapping("/auth/signup")
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) { // key=value (x-www-form-urlencoded)
        log.info("SignupDto : {}", signupDto.toString());
        // User <- SignupDto
        User user = signupDto.toEntity();
        log.info("User : {}", user.toString());
        User userEntity = authService.signup(user);
        System.out.println(userEntity);
        return "auth/signin";
    }
}
