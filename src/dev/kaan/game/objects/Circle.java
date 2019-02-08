package dev.kaan.game.objects;

import java.awt.Point;
import java.util.ArrayList;


public class Circle  {
	private int radius;
	public int x,y;
	public ArrayList<Point> points=new ArrayList<Point>();
	public boolean isCircular=true;
	
	public Circle(int cor1,int cor2,int r)
	{
		x=cor1;
		y=cor2;
		radius=r;
	}
	
	public void calculatePoints()
	{
		
		Point p1=new Point(x,y);
		points.add(p1);
		Point p2=new Point(x+2*radius,y+2*radius);
		points.add(p2);
	}

	
	public boolean checkBound(int x, int y) 
	{
		Point center=new Point(x+radius,y+radius);
		//distance between two points
		int a=(x-center.x)*(x-center.x);
		int b=(y-center.y)*(y-center.y);
		double distance= Math.sqrt((double)a+(double)b);
		
		if(distance<=this.radius)
			return true;
		else 
			return false;
		
	}
	
}
