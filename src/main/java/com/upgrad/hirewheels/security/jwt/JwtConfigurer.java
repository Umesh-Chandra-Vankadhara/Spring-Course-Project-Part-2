package com.upgrad.hirewheels.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class JwtConfigurer extends SecurityConfigurerAdapter<org.springframework.security.web.DefaultSecurityFilterChain, HttpSecurity> {

  private JwtTokenProvider jwtTokenProvider;

  public JwtConfigurer(JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    com.upgrad.hirewheels.security.jwt.JwtTokenFilter customFilter = new com.upgrad.hirewheels.security.jwt.JwtTokenFilter(jwtTokenProvider);
    http.addFilterAfter(customFilter, UsernamePasswordAuthenticationFilter.class);
  }
}