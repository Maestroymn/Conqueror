package dev.kaan.game.objects;

import java.awt.Point;
import java.util.ArrayList;

public abstract class Shape {
	protected Point leftTop;
	protected boolean isCircular;
	protected ArrayList<Point> points;

	
	public Shape(int cor1,int cor2, boolean isCirc )
	{
		leftTop=new Point(cor1,cor2);
		isCircular=isCirc;
		points= new ArrayList<Point>();
		points.add(leftTop);
		
	}
	
	public boolean checkBound(int x,int y)
	{
		return true;
	}
	
	public void calculatePoints()
	{
		
	}


	
}
