package dev.kaan.game.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import dev.kaan.game.objects.Circle;

public abstract class UIObject {
	protected float x,y;
	protected int width,height;
	protected Rectangle bounds,cBounds;
	public boolean hovering,isCircular;

	
	public UIObject(float x, float y, int w, int h,boolean isCircular) {
		this.x=x;
		this.y=y;
		width=w;
		height=h;
		this.isCircular=isCircular;
		if(isCircular==false)
			bounds = new Rectangle((int) x, (int)y ,w,h);
		else {
			cBounds=new Rectangle((int) x, (int)y ,w,h);
		}
	}
	
	public  abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void onClick();
	
	public void onMouseMove(MouseEvent e) {
		if(isCircular==false) {
		if(bounds.contains(e.getX(), e.getY())) 
			hovering=true;
		else 
			hovering=false;
		}
		else {
			if(cBounds.contains(e.getX(), e.getY())) 
				hovering=true;
			else 
				hovering=false;
			}
		}
			
	
	
	public void onMouseRelease(MouseEvent e) {
		if(hovering)
			onClick();
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isHovering() {
		return hovering;
	}

	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}
	
	
}
