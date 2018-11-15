package org.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class circle2 implements shape
{
private Point center;

@Override
public void draw() {
	
	System.out.println("Drawing Circle");
	System.out.println("Circle: Point is:= (" +center.getX() +"," + center.getY() + ")");
}

public Point getCenter() {
	return center;
}

/*
You can use @Autowired annotation on setter methods to get ref id of the <property> element in XML configuration file(spring.xml).
When Spring finds an @Autowired annotation used with setter methods, it tries to perform byType autowiring on the method.
*/

@Autowired
public void setCenter(Point center) {
	this.center = center;
}
}
