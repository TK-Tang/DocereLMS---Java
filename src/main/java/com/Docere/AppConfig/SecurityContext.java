package com.Docere.AppConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity
@EnableWebSecurity
@Import({SpringConfiguration.class})
public class SecurityContext extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;	
	
	// authorizeRequests() -> use-expresions = "true"
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/createaccount","/error", "/register", "/login", "/newaccount", "/resources/**").permitAll()
			.antMatchers("/**", "/*", "/").authenticated()
			.anyRequest().authenticated()
				.and()
			.formLogin().loginPage("/login").defaultSuccessUrl("/dashboard").loginProcessingUrl("/j_spring_security_check")
			.usernameParameter("username").passwordParameter("password").failureUrl("/login?error=true")
				.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true);
	}
	
	// Equivalent of jdbc-user-service in XML
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("SELECT username, password, enabled FROM Users WHERE username=?")
			.authoritiesByUsernameQuery("SELECT username, authority FROM Authorities WHERE username=?");
	}
	
	  @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.debug(false);
	    }

}
