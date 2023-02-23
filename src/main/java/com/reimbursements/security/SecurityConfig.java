package com.reimbursements.security;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.cors().configurationSource(new CorsConfigurationSource() {
//			@Override
//			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//				CorsConfiguration config = new CorsConfiguration();
//				config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
//				config.setAllowedMethods(Collections.singletonList("*"));
//				config.setAllowCredentials(true);
//				config.setAllowedHeaders(Collections.singletonList("*"));
//				config.setMaxAge(3600L);
//				return config;
//			}
//		}).and().csrf().ignoringAntMatchers("/login").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//				.and().authorizeRequests()
//				
//				.antMatchers("/reimbursements/add-new-reimbursement","/users/user-details" ).authenticated()
//				.antMatchers("/users/get-all-users", "/reimbursements/update-reimbursement", "/users/authority-registration").hasRole("MANAGER")
//				.antMatchers("/users/register","/login").permitAll()
//				.and().formLogin();
//	}
	
	   public void addCorsMappings(CorsRegistry registry) {
           registry.addMapping("/*").
           allowedOrigins("*").
           allowedMethods("*").
           allowedHeaders("*").
           allowCredentials(true);
       }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().ignoringAntMatchers("/login").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and().authorizeRequests()
			//.authorizeRequests()
			.antMatchers("/users/register", "/reimbursements/add-new-reimbursement", "/users/user-details").authenticated()
			.antMatchers("/users/get-all-users", "/reimbursements/update-reimbursement", "/users/authority-registration").hasRole("MANAGER")
			.antMatchers("/login").permitAll()
			.and().formLogin();
	}
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }}
