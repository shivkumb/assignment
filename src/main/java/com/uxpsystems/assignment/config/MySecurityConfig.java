package com.uxpsystems.assignment.config;

import com.uxpsystems.assignment.security.serviceImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity

public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailesServiceImpl customUserDetailsService;
	
	@Autowired
	JwtAuthenticationFilter jwtFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().cors().disable().authorizeRequests().antMatchers("/token").permitAll()
				.antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {

		 return new BCryptPasswordEncoder();
	}

	
	 @Bean public AuthenticationManager authenticationManagerBean() throws
	 Exception { return super.authenticationManagerBean(); }
	 

}
