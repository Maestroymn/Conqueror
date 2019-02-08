package dev.kaan.game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import dev.kaan.game.Handler;
import dev.kaan.game.gfx.Assets;
import dev.kaan.game.mainCodes.Player;
import dev.kaan.game.mainCodes.Region;
import dev.kaan.game.objects.Circle;
import dev.kaan.game.ui.ClickListener;
import dev.kaan.game.ui.UIImageButton;
import dev.kaan.game.ui.UIImageRegion;
import dev.kaan.game.ui.UIManager;
import dev.kaan.game.ui.UIObject;

public class CapitalState extends State{
	private Handler handler;
	private UIManager uiManager;
	private State gameState;
	public ArrayList<Region> regions=new ArrayList<Region>();
	public ArrayList<Circle> circles=new ArrayList<Circle>();
	public ArrayList<Player> players = new ArrayList<Player>();
	public boolean Start=true,player1=false,player1withCap=false,player2=false,player2withCap=false,player3=false,player3withCap=false;
	public UIObject player1B,player2B,player3B,startB;
	
	public CapitalState(Handler handler,ArrayList<Region> regions,ArrayList<Circle> circles,ArrayList<Player> players) {
		super(handler);
		this.regions=regions;
		this.circles=circles;
		this.players=players;
		this.handler=handler;
		uiManager=new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);
		
		//REGIONS
				addUIObject(14,52,42,78,0);
				addUIObject(79,104,107,127,1);
				addUIObject(82,219,114,266,2);
				addUIObject(129,158,174,205,3);
				addUIObject(220,10,267,39,4);
				addUIObject(67,37,130,75,5);
				addUIObject(146,107,165,138,6);
				addUIObject(194,97,218,138,7);
				addUIObject(79,161,105,188,8);
				addUIObject(180,402,194,466,9);
				addUIObject(170,321,247,372,10);
				addUIObject(148,332,187,387,11);
				addUIObject(156,294,190,309,12);
				addUIObject(418,390,452,424,13);
				addUIObject(459,351,498,394,14);
				addUIObject(425,305,451,323,15);
				addUIObject(532,453,545,487,16);
				addUIObject(345,291,383,350,17);
				addUIObject(426,443,458,493,18);
				addUIObject(313,131,347,181,19);
				addUIObject(339,87,357,101,20);
				addUIObject(391,153,421,186,21);
				addUIObject(397,70,429,100,22);
				addUIObject(394,207,428,243,23);
				addUIObject(451,69,496,148,24);
				addUIObject(333,204,360,255,25);
				addUIObject(530,165,571,209,26);
				addUIObject(612,183,671,246,27);
				addUIObject(580,244,621,297,28);
				addUIObject(653,99,692,136,29);
				addUIObject(760,147,788,200,30);
				addUIObject(710,44,773,68,31);
				addUIObject(462,250,515,287,32);
				addUIObject(658,153,697,187,33);
				addUIObject(663,294,690,322,34);
				addUIObject(669,37,704,64,35);
				addUIObject(567,53,584,128,36);
				addUIObject(585,28,634,94,37);
				addUIObject(763,440,810,494,38);
				addUIObject(658,388,703,416,39);
				addUIObject(744,374,772,394,40);
				addUIObject(705,460,733,504,41);
		
				player1B=(new UIImageButton(200,621,355,175,Assets.player1,new ClickListener() {
					public void onClick() {
						player1withCap=true;
						Start=false;
					}
				}));
				player2B =(new UIImageButton(200,621,355,175,Assets.player2,new ClickListener() {
					public void onClick() {
						player1withCap=false;
						player2withCap=true;
					}
				}));
				player3B=(new UIImageButton(200,621,355,175,Assets.player3,new ClickListener() {
					public void onClick() {
						player2withCap=false;
						player3withCap=true;
					}
				}));
				startB=(new UIImageButton(673,592,355,175,Assets.startgame,new ClickListener() {
					public void onClick() {
						player3withCap=false;
						handler.getMouseManager().setUiManager(null);
						gameState=new GameState(handler,regions,circles,players);
						State.setState(gameState);
					}
				}));
	}


	public void tick() {
		if(Start) {
			uiManager.addObject(player1B);
		}
		if(player1withCap) {
			uiManager.addObject(player2B);
		}
		if(player2withCap) {
			uiManager.addObject(player3B);
		}
		if(player3withCap) {
			uiManager.addObject(startB);
		}
		uiManager.tick();

	}


	public void render(Graphics g) {
		g.drawImage(Assets.background, 0, 0, null);
		
		uiManager.render(g);
		Font font=new Font("Forte",Font.BOLD,25);
		g.setFont(font);
		for(int a=0;a<circles.size();a++) {
			if(regions.get(a).isCapital==false) {
			g.setColor(Color.BLACK);
            g.drawOval(circles.get(a).points.get(0).x, circles.get(a).points.get(0).y, (circles.get(a).points.get(1).x-circles.get(a).points.get(0).x), (circles.get(a).points.get(1).x-circles.get(a).points.get(0).x));   
			g.fillOval(circles.get(a).points.get(0).x, circles.get(a).points.get(0).y, (circles.get(a).points.get(1).x-circles.get(a).points.get(0).x), (circles.get(a).points.get(1).x-circles.get(a).points.get(0).x));
			}
			else {
				g.setColor(Color.WHITE);
				g.drawOval(circles.get(a).points.get(0).x, circles.get(a).points.get(0).y, (circles.get(a).points.get(1).x-circles.get(a).points.get(0).x), (circles.get(a).points.get(1).x-circles.get(a).points.get(0).x));   
				g.fillOval(circles.get(a).points.get(0).x, circles.get(a).points.get(0).y, (circles.get(a).points.get(1).x-circles.get(a).points.get(0).x), (circles.get(a).points.get(1).x-circles.get(a).points.get(0).x));
				g.setColor(Color.BLACK);
				g.drawString("C", circles.get(a).points.get(0).x, circles.get(a).points.get(0).y);
			}
			}
	}
	
	public void addUIObject(int x, int y,int circX,int circY,int index) {
		if(regions.get(index).owner.playerID==1)
			uiManager.addObject(new UIImageRegion(x,y,circX,circY,Assets.RedRegions,new ClickListener() {
				public void onClick() {
					if(player1==false) {
					regions.get(index).owner.setCapital(regions.get(index));
						player1=true;
					}
						
				}
		},index));
		else if(regions.get(index).owner.playerID==2)
			uiManager.addObject(new UIImageRegion(x,y,circX,circY,Assets.YellowRegions,new ClickListener() {
				public void onClick() {
					if(player2==false) {
						regions.get(index).owner.setCapital(regions.get(index));
							player2=true;
						}
				}
		},index));
		else if(regions.get(index).owner.playerID==3)
			uiManager.addObject(new UIImageRegion(x,y,circX,circY,Assets.BlueRegions,new ClickListener() {
				public void onClick() {
					if(player3==false) {
						regions.get(index).owner.setCapital(regions.get(index));
							player3=true;
						}
				}
		},index));
	}
}
