package com.sprintinaction.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.sprintinaction.jpa")
public class JPAConfig {
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
	  LocalEntityManagerFactoryBean emfb
	      = new LocalEntityManagerFactoryBean();
	  emfb.setPersistenceUnitName("manager1");
	  return emfb;
	}
}
