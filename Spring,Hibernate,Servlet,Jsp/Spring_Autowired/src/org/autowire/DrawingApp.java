package org.autowire;
//import org.autowire.collection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		
	ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
	//collection t=(collection) context.getBean("triangle");
	shape t=(shape) context.getBean("circle2");
	t.draw();
	}

}
