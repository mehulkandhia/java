package com.Annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.ConfigureDemo;
import com.shop.Product;

public class SpringAnnotation {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigureDemo.class);
		
		Product p=(Product) context.getBean("product");
		p.setProductId("P001");
		p.setProductName("Tur Daal");
		p.setPrice(100);
		
		System.out.println("Product Id:" +p.getProductId());
		System.out.println("Product Name:" +p.getProductName());
		System.out.println("Price:" +p.getPrice());
	}

}
