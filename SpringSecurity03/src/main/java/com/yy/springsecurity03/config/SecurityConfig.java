package com.yy.springsecurity03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    UserDetailsService userDetailsService() {
//        return username -> {
//            com.yy.springsecurity01.pojo.User user = new User();
//            user.setName("Tom");
//            user.setId(1);
//            String encode = passwordEncoder().encode("111111");
//            user.setPassword(encode);
//            user.setTid(1);
//            return new UserDetailsImpl(user);
//        };
//    }
}
