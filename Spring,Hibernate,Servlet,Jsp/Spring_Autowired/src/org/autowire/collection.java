package org.autowire;

public class collection {
	private Point pointA;
	private Point pointB;
	private Point pointC;

	
	/*private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}*/
	



public void draw()
{
	/*for(Point point: points)
	{
		System.out.println("Point = (" +point.getX() +"," + point.getY() + "}");
	}*/
	System.out.println("Point A= (" +getPointA().getX() +"," + getPointA().getY() + ")");
	System.out.println("Point B= (" +getPointB().getX() +"," + getPointB().getY() + ")");
	System.out.println("Point C= (" +getPointC().getX() +"," + getPointC().getY() + ")");
}


public Point getPointA() {
	return pointA;
}


public void setPointA(Point pointA) {
	this.pointA = pointA;
}


public Point getPointB() {
	return pointB;
}


public void setPointB(Point pointB) {
	this.pointB = pointB;
}


public Point getPointC() {
	return pointC;
}


public void setPointC(Point pointC) {
	this.pointC = pointC;
}
	
	
}
