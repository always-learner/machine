package com.ascode.qrcodegenerator.configs.security;

import com.ascode.qrcodegenerator.services.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/save").permitAll()
                .antMatchers("/qrcode/**", "/users/**", "/user/**").hasAuthority("ADMIN")
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().successForwardUrl("/dashboard")
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("email")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
