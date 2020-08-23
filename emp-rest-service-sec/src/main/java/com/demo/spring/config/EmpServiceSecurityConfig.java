package com.demo.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class EmpServiceSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/emp/**").hasAnyRole("USER", "ADMIN").and().httpBasic().and().csrf()
				.disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("scott")
				.password("$2a$10$ivKecqhZnjcB8.JkSH2rseDe7.c6J/7UjLS0j0OtChhpZa8GDI4aC").roles("USER");
		auth.inMemoryAuthentication().withUser("james")
				.password("$2a$10$ivKecqhZnjcB8.JkSH2rseDe7.c6J/7UjLS0j0OtChhpZa8GDI4aC").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("martin")
				.password("$2a$10$ivKecqhZnjcB8.JkSH2rseDe7.c6J/7UjLS0j0OtChhpZa8GDI4aC").roles("ACCOUNT");
	}
}
