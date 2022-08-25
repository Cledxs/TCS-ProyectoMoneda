package com.demo.pocmonedaapih2jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

  @Autowired
  private JWTAuthFilter filter;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class)
        .csrf().disable()
        .cors().and().requestMatchers().antMatchers("/api-demo/v1/*").and().logout().permitAll().and()
        .authorizeRequests().antMatchers(HttpMethod.POST, "/authenticate").permitAll()
        .anyRequest().authenticated();
  }
}