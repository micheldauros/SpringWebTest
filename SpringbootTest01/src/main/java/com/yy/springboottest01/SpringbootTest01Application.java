package com.yy.springboottest01;

import com.yy.springboottest01.pojo.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@ServletComponentScan
@EnableScheduling
@SpringBootApplication
@EnableWebSecurity
public class SpringbootTest01Application implements CommandLineRunner {

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
        users.createUser(User.withUsername("张三").password("123456").roles("vip2","vip3").build());
        users.createUser(User.withUsername("李四").password("{666666").roles("vip1").build());
        return users;
    }


    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception {
        return httpSecurity.csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3")
                .and().formLogin()
                .and().build();


    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("level1/**").hasRole("vip1")
//                .antMatchers("level2/**").hasRole("vip2")
//                .antMatchers("level3/**").hasRole("vip3");
//        http.formLogin();
//    }
        private static final Logger log = LoggerFactory.getLogger(SpringbootTest01Application.class);
    @Autowired
    public JdbcTemplate jdbcTemplate;
        SpringbootTest01Application(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        public static void main (String[]args){
            SpringApplication.run(SpringbootTest01Application.class, args);
        }

        @Override
        public void run (String...strings){

            log.info("Creating tables");

            jdbcTemplate.execute("DROP TABLE  IF EXISTS customers");
            jdbcTemplate.execute("CREATE TABLE customers(" +
                    "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

            // Split up the array of whole names into an array of first/last names
            List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
                    .map(name -> name.split(" "))
                    .collect(Collectors.toList());

            // Use a Java 8 stream to print out each tuple of the list
            splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

            // Uses JdbcTemplate's batchUpdate operation to bulk load data
            jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

            log.info("Querying for customer records where first_name = 'Josh':");
            jdbcTemplate.query(
                    "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[]{"Josh"},
                    (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
            ).forEach(customer -> log.info(customer.toString()));
        }
    }