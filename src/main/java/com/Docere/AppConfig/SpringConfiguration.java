package com.Docere.AppConfig;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
//import org.hibernate.SessionFactory;/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.Docere.Authority.AuthorityDAOImpl;
import com.Docere.Authority.AuthorityServiceImpl;
import com.Docere.User.UserDAOImpl;
import com.Docere.User.UserServiceImpl;



@EnableWebMvc
@Configuration
@ComponentScan({"com.Docere"})
@PropertySources(value = {@PropertySource("/WEB-INF/persistence-mysql.properties")})
public class SpringConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	private Environment env;
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}
	
	@Bean
	public DataSource dataSource(){
		final BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(this.env.getProperty("jdbc.driverClassName"));
		ds.setUrl(this.env.getProperty("jdbc.url"));
		ds.setUsername(this.env.getProperty("jdbc.user"));
		ds.setPassword(this.env.getProperty("jdbc.pass"));
		
		return ds;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public InternalResourceViewResolver getViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean(name="multipartResolver")
	public MultipartResolver multipartResolver(){
		return new CommonsMultipartResolver();
	}
	
	//<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>//
	
	@Bean
	public UserDAOImpl userDAOImpl(){
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		
		return userDAOImpl;
	}
	
	@Bean
	public UserServiceImpl userServiceImpl(){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		return userServiceImpl;
	}
	
	@Bean
	public AuthorityDAOImpl authorityDAOImpl(){
		AuthorityDAOImpl authorityDAOImpl = new AuthorityDAOImpl();
		
		return authorityDAOImpl;
	}
	
	@Bean
	public AuthorityServiceImpl authorityServiceImpl(){
		AuthorityServiceImpl authorityServiceImpl = new AuthorityServiceImpl();
		
		return authorityServiceImpl;
	}
	
	
}
