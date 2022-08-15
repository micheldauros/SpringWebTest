package com.yy.springsecurity01.config;

import com.yy.springsecurity01.pojo.User;
import com.yy.springsecurity01.pojo.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationProvider;
import org.springframework.security.authentication.jaas.JaasAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    @Bean
//    AuthenticationManager authenticationManager(){
//        return authentication -> {};
//    }

//    @Resource
//    private AuthenticationConfiguration authenticationConfiguration;

    //    @Bean
//    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService)
//            throws Exception {
//        Map<String ,Object> headers=new HashMap<>();
//        headers.put("alg","HS265");
//        headers.put("typ","JWT");
//        Map<String ,Object> claims=new HashMap<>();
//        claims.put("username","Terry");
//        claims.put("id",1233);
//        Jwt a = new Jwt("abcdefg", null, null, headers, claims);
//
//
//
//
//
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .authenticationProvider(new JwtAuthenticationProvider(JwtDecoders.fromIssuerLocation())
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder)
//                .and()
//                .build();
//    }
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
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
         return authenticationManagerBuilder
                 .authenticationProvider(new JaasAuthenticationProvider())
                 .authenticationProvider(new TestingAuthenticationProvider())
//                 .authenticationProvider(new JwtAuthenticationProvider(NimbusJwtDecoder.withSecretKey("abcdabcdabcdabcd").build()))
                 .build();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .csrf().disable()
                .authenticationManager(authenticationManager)
                .securityContext();

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
