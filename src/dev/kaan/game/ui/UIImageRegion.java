package dev.kaan.game.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class UIImageRegion extends UIObject{
	
	private ArrayList<BufferedImage> images;
	private ClickListener clicker;
	private int index;
	private int x,y;
	
	public UIImageRegion(float x, float y, int circX,int circY,ArrayList<BufferedImage> images, ClickListener clicker,int index) {
		super(circX, circY, 14, 14,true);
		this.images=images;
		this.x=(int)x;
		this.y=(int)y;
		this.clicker=clicker;
		this.index=index;
		
	}

	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(hovering) {
			g.drawImage(images.get(index+42), (int)x, (int)y, images.get(index+42).getWidth(),images.get(index+42).getHeight(),null);
		}else 
			g.drawImage(images.get(index), (int)x, (int)y, images.get(index).getWidth(),images.get(index).getHeight(),null);
		
	}

	@Override
	public void onClick() {
		clicker.onClick();
		
	}

}
