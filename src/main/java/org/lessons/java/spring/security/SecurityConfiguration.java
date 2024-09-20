package org.lessons.java.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	@SuppressWarnings("removal")
		SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.requestMatchers("/user").hasAuthority("USER")
			.requestMatchers("/admin").hasAuthority("ADMIN")
			.requestMatchers("/").permitAll()
			.and().formLogin()
			.and().logout();
		return http.build();
	}
	
	@Bean
	DatabaseUserDetailsService userDetailsService() {
	return new DatabaseUserDetailsService();
	}

}
