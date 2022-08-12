package com.yy.springsecurity01.config;

import com.yy.springsecurity01.pojo.User;
import com.yy.springsecurity01.pojo.UserDetailsImpl;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.TestingAuthenticationProvider;
import org.springframework.security.authentication.jaas.JaasAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecurityConfig {

//    @Bean
//    AuthenticationManager authenticationManager(){
//        return authentication -> {};
//    }

    @Resource
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    AuthenticationManager authenticationManager(){
        List<AuthenticationProvider> list=new ArrayList<>();
        list.add(new JaasAuthenticationProvider());
        list.add(new TestingAuthenticationProvider());
        return new ProviderManager(list);
    }
    @Bean
    UserDetailsService userDetailsService() {
        return username -> {
            com.yy.springsecurity01.pojo.User user = new User();
            user.setName("Tom");
            user.setId(1);
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encode = bCryptPasswordEncoder.encode("111111");
            user.setPassword(encode);
            user.setTid(1);
            return new UserDetailsImpl(user);
        };
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http,AuthenticationManager authenticationManager) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .csrf().disable()
                .authenticationManager(authenticationManager)
                .securityContext()

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().antMatchers("/hello");
    }
}
