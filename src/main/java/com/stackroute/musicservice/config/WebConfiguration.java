package com.stackroute.musicservice.config;
//import org.h2.server.web.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;

@Configuration
@ComponentScan("com.stackroute.*")
public class WebConfiguration {
    /*@Bean
    ServletRegistrationBean h2servletRegistration()
    {
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;
    }*/
    @Autowired
    private Environment environment;
    @Bean("dataSource")
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.url"));
        dataSource.setUrl(environment.getProperty("spring.datasource.driverClassName"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));

        return dataSource;
    }
}

