package com.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureDemo {

	@Bean(name="product")
	public Product getProductBean() 
	{
		//System.out.println("===Spring container created the Product Bean and stored");
		return new Product();
	}
}
