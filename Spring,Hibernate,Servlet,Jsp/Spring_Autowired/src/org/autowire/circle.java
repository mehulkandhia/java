package org.autowire;
import org.springframework.beans.factory.annotation.Required;

public class circle implements shape {
private Point center;

@Override
public void draw()
{
	System.out.println("Drawing Circle");
	System.out.println("Circle: Point is:= (" +center.getX() +"," + center.getY() + ")");
}

public Point getCenter() {
	return center;
}

/*
In this example Circle class has the center property as required field declare with the @Required annotation.
The @Required when written on top of setCenter() method makes it sure that center property must have been set else it will give compile time error message
org.springframework.beans.factory.BeanInitializationException: Property ‘center‘ is required for bean ‘circle’.
*/
@Required
public void setCenter(Point center) {
	this.center = center;
}


}
