package dev.kaan.game.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width,height;
	
	
	public Display(String title, int w, int h) {
		this.title=title;
		width=w;
		height=h;
		createDisplay();
	}
	
	private void createDisplay()
	{
		frame=new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to close properly
		frame.setResizable(false); //dragging windows 
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); //must set true
		
		canvas=new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack(); //resize the window to see it fully
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
