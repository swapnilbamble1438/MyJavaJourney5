  package com.config;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DataSource dataSource;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		
		
		
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder);
		
		
		
		// JDBCUserDetailsManager implements UserDetailsManager Interface

		
		// so we have done JDBCAuthentication here
		// 
		// here loadUserByUsername method will verfiy 
		// the login details to do the login.
		// loadUserByUsername method is present in UserDetails interface
		// which is implemented by UserDetailsManager interface
		
		/*
	JDBCUserDetailsManager(c)
		|						createUser(){}
		|                       deleteUser(){}
	    |                       updateUser(){}
	    |						updatePassword(){}                    
	    |                       loadUserByUsername(){}
	   \|/
	UserDetailsManager(I)  
	    |						createUser(){}
		|                       deleteUser(){}
	    |                       updateUser(){}
	    |						updatePassword(){}                    
	    |                       
	   \|/ 
	UserDetailsService(I)
	                           loadUserByUsername(){}
	                           
	    */                       
	
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()
		.antMatchers("/hii","/admin").hasAuthority("ADMIN")
		.antMatchers("/bye","/normal").hasAuthority("NORMAL")
		.antMatchers("/helloworld").permitAll()
		.and() 
		.formLogin().loginPage("/myLogin").loginProcessingUrl("/doLogin") 
		.and()
		.logout()
		.and()
		.httpBasic() 
		.and()
		.exceptionHandling().accessDeniedPage("/accessdenied")
		;
	}
	
	
	
	
	
}
