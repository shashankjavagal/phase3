package com.org.sportyshoes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.org.sportyshoes.service.UserService;


@Configuration
public class UserAppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired 
	UserService userService;
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoAutenticationProvider=new DaoAuthenticationProvider();
		daoAutenticationProvider.setUserDetailsService(userDetailsService);
		daoAutenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return daoAutenticationProvider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
	    .authorizeRequests().antMatchers("/login").permitAll()
	    .antMatchers("/admin/**").hasAuthority("ADMIN")
	    .antMatchers("/user").hasAuthority("USER")
	    .antMatchers("/").permitAll()
	    .antMatchers("/register","/registerUser").permitAll()
	    .anyRequest().authenticated()
	    .and()
	    .formLogin()
	    .loginPage("/login").permitAll()
	    .and()
	    .logout().invalidateHttpSession(true)
	    .clearAuthentication(true)
	    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	    .logoutSuccessUrl("/logout-sucess").permitAll();
		   
   
		   
	}
	
	
	
	

}
