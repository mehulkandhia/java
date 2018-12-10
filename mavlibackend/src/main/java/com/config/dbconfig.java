package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dao.impl.daoimpl;
//import com.model.UserDetails;
import com.model.Category;
import com.model.UserDetails;
import com.model.product;
import com.model.supplier;
//import com.model.product;
@Configuration
@EnableTransactionManagement
@ComponentScan("com")
public class dbconfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("System");
		dataSource.setPassword("Namrata4#");
		return dataSource;
	}

	//@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		System.out.println("Session Object created..");
		builder.addProperties(properties);
		builder.addAnnotatedClass(Category.class);
		builder.addAnnotatedClass(product.class);
		builder.addAnnotatedClass(UserDetails.class);
		builder.addAnnotatedClass(supplier.class);
		System.out.println("Properties added");

		return builder.buildSessionFactory();
	}

	// All the hibernate properties will be returned in this method
	@Autowired
	@Bean(name = "categorydaoimpl")
	public daoimpl getUserData(SessionFactory sf) {
		return new daoimpl(sf);
	}
	
	
	
	@Bean(name = ("transactionManager"))
	public HibernateTransactionManager getTransactionManager(SessionFactory sf) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sf);
		return transactionManager;
	}
}
