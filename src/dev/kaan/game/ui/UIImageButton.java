package dev.kaan.game.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class UIImageButton extends UIObject{

	private ArrayList<BufferedImage> images;
	private ClickListener clicker;
	
	public UIImageButton(float x, float y, int w, int h,ArrayList<BufferedImage> images, ClickListener clicker) {
		super(x, y, w, h,false);
		this.images=images;
		this.clicker=clicker;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(hovering)
			g.drawImage(images.get(1), (int)x, (int)y, images.get(1).getWidth(),images.get(1).getHeight(),null);
		else 
			g.drawImage(images.get(0), (int)x, (int)y, images.get(0).getWidth(),images.get(0).getHeight(),null);
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
