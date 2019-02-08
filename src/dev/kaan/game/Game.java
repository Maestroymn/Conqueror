package dev.kaan.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import dev.kaan.game.display.Display;
import dev.kaan.game.gfx.Assets;
import dev.kaan.game.input.MouseManager;
import dev.kaan.game.mainCodes.Player;
import dev.kaan.game.mainCodes.Region;
import dev.kaan.game.objects.Circle;
import dev.kaan.game.state.GameState;
import dev.kaan.game.state.MenuState;
import dev.kaan.game.state.State;

public class Game implements Runnable { // base codes for our game
	private Display display;
	public int width, height;
	public String title;
	ArrayList<Region> regions = new ArrayList<Region>();
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<Region> gameRegions = new ArrayList<Region>();
	public ArrayList<Circle> circles=new ArrayList<Circle>();
	
	private Thread thread;
	public boolean running = false;

	private BufferStrategy bs; 
	private Graphics g;
	
	//Input
	private MouseManager mouseManager;
	
	//States
	public State menuState;
	
	//Handler
	private Handler handler;
	
	//Players
	public Player player1;
	public Player player2;
	public Player player3;
	
	
	
	public Game(String title, int w, int h) {
		width = w;
		height = h;
		this.title=title;
		mouseManager=new MouseManager();
	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler=new Handler(this);
		
		player1=new Player(1);
		players.add(player1);
		player2=new Player(2);
		players.add(player2);
		player3=new Player(3);
		players.add(player3);
		
		player1.setRegions(gameRegions);

		player1.distributeRegions(gameRegions);
		player2.distributeRegions(gameRegions);
		
		while (player3.currentRegions.size() != 14) { // geri kalan 14 ülkeyi direk 3.oyuncuya veriyor
			for (int a = 0; a < gameRegions.size(); a++) {
				player3.currentRegions.add(gameRegions.get(a));
				player3.currentRegions.get(a).owner = player3;
			}
		}
		
		for(int b=0;b<player1.currentRegions.size();b++)
			regions.add(player1.currentRegions.get(b));
		for(int b=0;b<player2.currentRegions.size();b++)
			regions.add(player2.currentRegions.get(b));
		for(int b=0;b<player3.currentRegions.size();b++)
			regions.add(player3.currentRegions.get(b));
		
		Collections.sort(regions, new Comparator<Region>() {
			public int compare(Region A,Region B) {
				if(A.regionID<B.regionID)
					return -1;
				else if (A.regionID==B.regionID)
					return 0;
				else
					return 1;
			}
		});
			
		setCircles(circles);
		for(int x=0;x<circles.size();x++)
			circles.get(x).calculatePoints();
		setImage(regions);
		
		menuState=new MenuState(handler,regions,circles,players);
		State.setState(menuState);
		
	}

	private void update() {
		if(State.getState()!=null)
			State.getState().tick();
	}

	private void render() {
		bs=display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3); //3 should be the max 
			return;
		}
		g=bs.getDrawGraphics();
		//clear screen first
		g.clearRect(0, 0, width, height);
		//Draw here!
		g.fillRect(0, 0, width, height);
		
		if(State.getState()!=null)
			State.getState().render(g);
		
		
		
		
		//***********************************************************************
		
		
	
		//End Drawing!
		bs.show();
		g.dispose();
	}

	public void run() {
		init();
		
		int fps=60;
		double timePerTick=1000000000/fps; //maximum amount of time to achieve
		double delta=0; 
		long now; 
		long lastTime=System.nanoTime(); //returns the nanotime of our computer
		long timer=0; //waits until 1 second pasts
		int ticks=0; 
		
		while (running) {
			now=System.nanoTime(); //current time of our computer
			delta+=(now-lastTime)/timePerTick; //we are using delta to show computer when to call update and render methods.
			timer+=now-lastTime; 
			lastTime=now;  
			
			if(delta>=1) {
			update();
			render();
			ticks++;
			delta--; //this all stuff to optimize the game
		}
			if(timer>=1000000000) {
				ticks=0;
				timer=0;
			}
						}
		stop();
	}

	public MouseManager getMouseManager()
	{
		return mouseManager;
	}
	
	public void setCircles(ArrayList<Circle> circles) {
		Circle c1=new Circle(42,78,7);
		circles.add(c1);
		Circle c2=new Circle(107,127,7);
		circles.add(c2);
		Circle c3=new Circle(114,266,7);
		circles.add(c3);
		Circle c4=new Circle(174,205,7);
		circles.add(c4);
		Circle c5=new Circle(267,39,7);
		circles.add(c5);
		Circle c6=new Circle(130,75,7);
		circles.add(c6);
		Circle c7=new Circle(165,138,7);
		circles.add(c7);
		Circle c8=new Circle(218,138,7);
		circles.add(c8);
		Circle c9=new Circle(105,188,7);
		circles.add(c9);
		Circle c10=new Circle(194,466,7);
		circles.add(c10);
		Circle c11=new Circle(247,372,7);
		circles.add(c11);
		Circle c12=new Circle(187,387,7);
		circles.add(c12);
		Circle c13=new Circle(190,309,7);
		circles.add(c13);
		Circle c14=new Circle(452,424,7);
		circles.add(c14);
		Circle c15=new Circle(498,394,7);
		circles.add(c15);
		Circle c16=new Circle(451,323,7);
		circles.add(c16);
		Circle c17=new Circle(545,487,7);
		circles.add(c17);
		Circle c18=new Circle(383,350,7);
		circles.add(c18);
		Circle c19=new Circle(458,493,7);
		circles.add(c19);
		Circle c20=new Circle(347,181,7);
		circles.add(c20);
		Circle c21=new Circle(357,101,7);
		circles.add(c21);
		Circle c22=new Circle(421,186,7);
		circles.add(c22);
		Circle c23=new Circle(429,100,7);
		circles.add(c23);
		Circle c24=new Circle(428,243,7);
		circles.add(c24);
		Circle c25=new Circle(496,148,7);
		circles.add(c25);
		Circle c26=new Circle(360,255,7);
		circles.add(c26);
		Circle c27=new Circle(571,209,7);
		circles.add(c27);
		Circle c28=new Circle(671,246,7);
		circles.add(c28);
		Circle c29=new Circle(621,297,7);
		circles.add(c29);
		Circle c30=new Circle(692,136,7);
		circles.add(c30);
		Circle c31=new Circle(788,200,7);
		circles.add(c31);
		Circle c32=new Circle(773,68,7);
		circles.add(c32);
		Circle c33=new Circle(515,287,7);
		circles.add(c33);
		Circle c34=new Circle(697,187,7);
		circles.add(c34);
		Circle c35=new Circle(690,322,7);
		circles.add(c35);
		Circle c36=new Circle(704,64,7);
		circles.add(c36);
		Circle c37=new Circle(584,128,7);
		circles.add(c37);
		Circle c38=new Circle(634,94,7);
		circles.add(c38);
		Circle c39=new Circle(810,494,7);
		circles.add(c39);
		Circle c40=new Circle(703,416,7);
		circles.add(c40);
		Circle c41=new Circle(772,394,7);
		circles.add(c41);
		Circle c42=new Circle(733,504,7);
		circles.add(c42);
	}
	
	public void setImage(ArrayList<Region> regions) {
		for(int a=0;a<regions.size();a++) {
			if(regions.get(a).owner.playerID==1)
			{
				regions.get(a).setImageOfRegion(Assets.RedRegions.get(a));
			}
			else if(regions.get(a).owner.playerID==2)
			{
				regions.get(a).setImageOfRegion(Assets.YellowRegions.get(a));
			}
			else
				regions.get(a).setImageOfRegion(Assets.BlueRegions.get(a));
		}
	}
	
	public synchronized void start() { // synchronized syntax is useful for threads
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
