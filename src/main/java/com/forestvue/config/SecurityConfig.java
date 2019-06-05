package com.forestvue.config;


import com.forestvue.security.CustomUserDetailsService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity(debug = true)
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Setter(onMethod_ = {@Autowired})
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/json").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .formLogin()
                .loginProcessingUrl("/login-processing")
                .failureForwardUrl("/auth-failure")
                .defaultSuccessUrl("/auth-success",false)
                .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSION_ID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerUserService()).
        passwordEncoder(passwordEncoder());
        String queryUser = "select userid, userpw, enabled from tbl_member where username = ? ";
        String queryDetails = "select userid, auth from tbl_member_auth where userid = ? ";
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(queryUser)
                .authoritiesByUsernameQuery(queryDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService customerUserService() {
        return new CustomUserDetailsService();
    }

}
