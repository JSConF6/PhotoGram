package com.jsconf.photogram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // 해당 파일로 시큐리티 활성화
@Configuration // IoC
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super 삭제 - 기존 시큐리티가 가지고 있는 기능이 다 비활성화됨.
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "comment/**").authenticated() // 해당 URL은 인증이 필요하다.
                .anyRequest().permitAll() // 그 외 다른 요청은 모두 인증 없이 가능
                .and()
                .formLogin()
                .loginPage("/auth/signin") // 인증이 필요한 페이지 요청 시 /auth/signin 으로 이동시킨다.
                .defaultSuccessUrl("/"); // 인증 성공 시 / 로 이동
    }
}
