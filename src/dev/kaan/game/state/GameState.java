package dev.kaan.game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import dev.kaan.game.Handler;
import dev.kaan.game.gfx.Assets;
import dev.kaan.game.mainCodes.Dice;
import dev.kaan.game.mainCodes.Player;
import dev.kaan.game.mainCodes.Region;
import dev.kaan.game.mainCodes.War;
import dev.kaan.game.objects.Circle;
import dev.kaan.game.ui.ClickListener;
import dev.kaan.game.ui.UIImageButton;
import dev.kaan.game.ui.UIImageRegion;
import dev.kaan.game.ui.UIManager;
import dev.kaan.game.ui.UIObject;

public class GameState extends State{
	public ArrayList<Region> regions=new ArrayList<Region>();
	public ArrayList<Circle> circles=new ArrayList<Circle>();
	public ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Integer> attdices = new ArrayList<Integer>();
	private UIManager uiManagerG;
	private Handler handler;
	private War war;
	private State endGameState;
	private Player player;
	private Region attacker,defender;
	private Dice dice = new Dice();
	private int attackerDice1,attackerDice2,attackerDice3,defenderDice1,defenderDice2,damage,attackpoint,defendpoint;
	private boolean player1Win=false,player2Win=false,player3Win=false,unexpectedConquer=false,attackRolled=false,defenceRolled=false,conquer=false,notNeighbours=false,defenceWin=false,tie=false,damageIsDone=false,startWar=false,attackChoosen=false,defendChoosen=false,attackClicked=false,defendClicked=false,warClicked=false,attackDice=false,defenceDice=false,player1turn=true,player2turn=false,player3turn=false;
	private UIObject attButton,defButton,warButton,attDiceButton,defDiceButton;
	Font font1=new Font("Forte",Font.BOLD,20);
	Font font=new Font("Forte",Font.BOLD,25);
	
	public GameState(Handler handler,ArrayList<Region> regions,ArrayList<Circle> circles,ArrayList<Player> players) {
		super(handler);
		this.handler=handler;
		this.players=players;
		this.regions=regions;
		this.circles=circles;
		uiManagerG=new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManagerG);

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
		
		attButton=(new UIImageButton(414,609,205,139,Assets.chooseAtt,new ClickListener() {
			public void onClick() {
				attackClicked=true;
			}
		}));
		uiManagerG.addObject(attButton);
		defButton=(new UIImageButton(655,610,205,139,Assets.chooseDef,new ClickListener() {
			public void onClick() {
				attackClicked=false;
				defendClicked=true;
			}
		}));
		uiManagerG.addObject(defButton);
		warButton=(new UIImageButton(882,619,109,118,Assets.attackButtons,new ClickListener() {
			public void onClick() {
				defenceRolled=false;
				warClicked=true;
			}
		}));
		uiManagerG.addObject(warButton);
		attDiceButton=(new UIImageButton(14,551,121, 50,Assets.rollAtt,new ClickListener() {
			public void onClick() {
				warClicked=false;
				attackDice=true;
				attackRolled=true;
			}
		}));
		uiManagerG.addObject(attDiceButton);
		defDiceButton=(new UIImageButton(814,12,51, 106,Assets.rollDef,new ClickListener() {
			public void onClick() {
				attackDice=false;
				attackRolled=false;
				defenceDice=true;
				defenceRolled=true;
			}
		}));
		uiManagerG.addObject(defDiceButton);
		
	}

	public void tick() {
		
		if(player1turn) {
			
			if(attackChoosen && defendChoosen) {
				if(attacker.isNeighbour(defender)) {
					attack();
				if(warClicked) {
					gameLoopPlayer1();
				}
				
			}
				
				else {
					notNeighbours=true;
				}
			}
			if(players.get(1).currentHP==0 && players.get(2).currentHP==0)
			{
				endGameState=new EndGameState(handler,regions,circles,players,true,false,false);
				State.setState(endGameState);
			}
			if(players.get(0).currentHP==0 && players.get(2).currentHP==0)
			{
				endGameState=new EndGameState(handler,regions,circles,players,false,true,false);
				State.setState(endGameState);
			}
			if(players.get(0).currentHP==0 && players.get(1).currentHP==0)
			{
				endGameState=new EndGameState(handler,regions,circles,players,false,false,true);
				State.setState(endGameState);
			}
		}
		else if(player2turn) {		
			if(attackChoosen && defendChoosen) {
				if(attacker.isNeighbour(defender)) {
				attack();
				if(warClicked) {
					gameLoopPlayer2();
				}
				
			}
				else {
					notNeighbours=true;
				}
				
			}
			if(players.get(1).currentHP==0 && players.get(2).currentHP==0)
			{
				endGameState=new EndGameState(handler,regions,circles,players,true,false,false);
				State.setState(endGameState);
			}
			if(players.get(0).currentHP==0 && players.get(2).currentHP==0)
			{
				endGameState=new EndGameState(handler,regions,circles,players,false,true,false);
				State.setState(endGameState);
			}
			if(players.get(0).currentHP==0 && players.get(1).currentHP==0)
			{
				endGameState=new EndGameState(handler,regions,circles,players,false,false,true);
				State.setState(endGameState);
			}
		}
		else if(player3turn) {
			
			if(attackChoosen && defendChoosen ) {
				if(attacker.isNeighbour(defender)) {
				attack();
				if(warClicked) {
					gameLoopPlayer3();
				}
			}
				else {
					notNeighbours=true;
				}
		}
		
			if(players.get(1).currentHP==0 && players.get(2).currentHP==0)
			{
				endGameState=new EndGameState(handler,regions,circles,players,true,false,false);
				State.setState(endGameState);
			}
			if(players.get(0).currentHP==0 && players.get(2).currentHP==0)
			{
				endGameState=new EndGameState(handler,regions,circles,players,false,true,false);
				State.setState(endGameState);
			}
			if(players.get(0).currentHP==0 && players.get(1).currentHP==0)
			{
				endGameState=new EndGameState(handler,regions,circles,players,false,false,true);
				State.setState(endGameState);
			}
		}
		uiManagerG.tick();
	}


	public void render(Graphics g) {
		g.drawImage(Assets.gameBackground, 0, 0, null);
		g.setFont(font);
		setImage(regions);
		if(player1turn) {
			g.drawImage(Assets.player1turn, 144, 623, null);

		}
		else if(player2turn) {
			g.drawImage(Assets.player2turn, 144, 623, null);

		}
		else if(player3turn) {
			g.drawImage(Assets.player3turn, 144, 623, null);

		}
		if(notNeighbours) {
			attackRolled=false;
			defenceRolled=false;
			conquer=false;
			unexpectedConquer=false;
			tie=false;
			defenceWin=false;
			damageIsDone=false;
			g.setFont(font1);
			g.drawString("You should choose neighbour areas to attack!" , 145, 587);
			notNeighbours=false;
		}
			
		
		
		g.drawString(players.get(0).HPtoString(), 885, 191);
		g.drawString(players.get(1).HPtoString(), 885, 252);
		g.drawString(players.get(2).HPtoString(), 885, 313);		
		g.setFont(font);
		if(attackRolled) {
			conquer=false;
			unexpectedConquer=false;
			defenceWin=false;
			tie=false;
			damageIsDone=false;
			g.setFont(font1);
			g.drawString("Attacker rolled: "+attackerDice1+", "+attackerDice2+", "+attackerDice3+" ==> "+attdices.get(1)+", "+attdices.get(2) , 145, 587);
		}
		if(defenceRolled) {
			g.setFont(font1);
			g.drawString("Defender rolled: "+defenderDice1+", "+defenderDice2  , 145, 587);
		}
		if(damageIsDone) {
			defenceRolled=false;
			tie=false;
			defenceWin=false;
			g.setFont(font1);
			g.drawString("Attacker side deals "+damage*50+" damage to the defender side.Roll dice again." , 145, 587);
			
		}
		if(conquer) {
			defenceRolled=false;
			tie=false;
			defenceWin=false;
			g.setFont(font1);
			g.drawString("Attacker side conquered the area! Player"+attacker.owner.playerID+" is ruling the are now!" , 145, 587);
		}
		if(unexpectedConquer) {
			defenceRolled=false;
			tie=false;
			defenceWin=false;
			g.setFont(font1);
			g.drawString("Unexpected Result! Player"+defender.owner.playerID+" is ruling all of your regions now!" , 145, 587);
		}
		if(tie) {
			defenceRolled=false;
			defenceWin=false;
			damageIsDone=false;
			g.setFont(font1);
			g.drawString("Nobody get hurt, End of the round." , 145, 587);
			
		}
		if(defenceWin) {
			defenceRolled=false;
			tie=false;
			damageIsDone=false;
			g.setFont(font1);
			g.drawString("Defending side deals "+damage*50*-1+" damage to the attacker side.End of the round." , 145, 587);
			
		}
		uiManagerG.render(g);
		if(attackChoosen)
		g.drawString(attacker.HPtoString(), 885, 432);
		if(defendChoosen)
		g.drawString(defender.HPtoString(), 885, 562);
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
	
	public void attack() {
		if(attackDice) {
			attdices.clear();
			attackerDice1=dice.RollDice();
			attdices.add(attackerDice1);
			attackerDice2=dice.RollDice();
			attdices.add(attackerDice2);
			attackerDice3=dice.RollDice();
			attdices.add(attackerDice3);
			
			Collections.sort(attdices, new Comparator<Integer>() {
				public int compare(Integer A,Integer B) {
					if(A<B)
						return -1;
					else if (A==B)
						return 0;
					else
						return 1;
				}
			});
			attackpoint=(int)((attdices.get(1) + attdices.get(2))*attacker.owner.multiplier)+attacker.owner.addition;
			System.out.println(attackerDice1+" "+attackerDice2+" "+attackerDice3);
			attackDice=false;
		}
		if(defenceDice) {
			
			defenderDice1=dice.RollDice();
			defenderDice2=dice.RollDice();
			defendpoint=defenderDice1+defenderDice2;
			System.out.println(defenderDice1+" "+defenderDice2);
			defenceDice=false;
			startWar=true;
		}
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
	public void gameLoopPlayer1() {

		damage=attackpoint-defendpoint;
		dice.hitDmg(attacker, defender,damage);
		attackDice = false;
		defenceDice = false;
		if(damage>0)
		{
			damageIsDone=true;
			warClicked=false;
			defenceRolled=false;
			if(defender.regionHP<=0) {
				damageIsDone=false;
				conquer=true;
				defender.regionHP=500;
				warClicked=false;
				defenceRolled=false;
				if(defender.isCapital) {
					
					for(int index=0;index<players.get(defender.owner.playerID-1).currentRegions.size();index++) {
							UIObject newArea=(new UIImageRegion(defender.owner.currentRegions.get(index).corx,defender.owner.currentRegions.get(index).cory,defender.owner.currentRegions.get(index).width,defender.owner.currentRegions.get(index).height,Assets.RedRegions,new ClickListener() {
								public void onClick() {
									if(attackClicked) {
										attackChoosen=true;
										System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
										attacker=regions.get(attacker.regionID-1);
									}
									else if(defendClicked) {
										defendChoosen=true;
										System.out.println("defender is "+regions.get(defender.regionID-1).toString());
										defender=regions.get(defender.regionID-1);
									}
								}
									
					},defender.owner.currentRegions.get(index).regionID-1));
							uiManagerG.setObject(defender.owner.currentRegions.get(index).regionID-1,newArea);
							defender.setImageOfRegion(Assets.RedRegions.get(defender.owner.currentRegions.get(index).regionID-1));
					}
					attacker.owner.currentHP+=14000;
					defender.isCapital=false;
				}else {
					
					UIObject newArea=(new UIImageRegion(defender.corx,defender.cory,defender.width,defender.height,Assets.RedRegions,new ClickListener() {
						public void onClick() {
							if(attackClicked) {
								attackChoosen=true;
								System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
								attacker=regions.get(attacker.regionID-1);
							}
							else if(defendClicked) {
								defendChoosen=true;
								System.out.println("defender is "+regions.get(defender.regionID-1).toString());
								defender=regions.get(defender.regionID-1);
							}
						}
							
			},defender.regionID-1));
					uiManagerG.setObject(defender.regionID-1,newArea);
					defender.setImageOfRegion(Assets.RedRegions.get(defender.regionID-1));
					attacker.owner.currentHP+=defender.regionHP;

				}
			}
		}
		else
		{
			damageIsDone=false;
			if(damage==0) {
				damageIsDone=false;
				defenceWin=false;
				tie=true;
			}
			else if(damage<0) {
				damageIsDone=false;
				tie=false;
				defenceWin=true;
				if(attacker.regionHP<=0) {
					unexpectedConquer=true;
					attacker.regionHP=500;
					if(attacker.isCapital) {
						for(int index=0;index<attacker.owner.currentRegions.size();index++) {
							if(defender.owner.playerID==2) {
								UIObject newArea=(new UIImageRegion(attacker.owner.currentRegions.get(index).corx,attacker.owner.currentRegions.get(index).cory,attacker.owner.currentRegions.get(index).width,attacker.owner.currentRegions.get(index).height,Assets.YellowRegions,new ClickListener() {
									public void onClick() {
										if(attackClicked) {
											attackChoosen=true;
											System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
											attacker=regions.get(attacker.regionID-1);
										}
										else if(defendClicked) {
											defendChoosen=true;
											System.out.println("defender is "+regions.get(defender.regionID-1).toString());
											defender=regions.get(defender.regionID-1);
										}
									}
										
						},attacker.owner.currentRegions.get(index).regionID-1));
								uiManagerG.setObject(attacker.owner.currentRegions.get(index).regionID-1,newArea);
								defender.setImageOfRegion(Assets.YellowRegions.get(attacker.owner.currentRegions.get(index).regionID-1));
								
							}
							else if(defender.owner.playerID==3) {
								UIObject newArea=(new UIImageRegion(attacker.owner.currentRegions.get(index).corx,attacker.owner.currentRegions.get(index).cory,attacker.owner.currentRegions.get(index).width,attacker.owner.currentRegions.get(index).height,Assets.BlueRegions,new ClickListener() {
									public void onClick() {
										if(attackClicked) {
											attackChoosen=true;
											System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
											attacker=regions.get(attacker.regionID-1);
										}
										else if(defendClicked) {
											defendChoosen=true;
											System.out.println("defender is "+regions.get(defender.regionID-1).toString());
											defender=regions.get(defender.regionID-1);
										}
									}
										
						},attacker.owner.currentRegions.get(index).regionID-1));
								uiManagerG.setObject(attacker.owner.currentRegions.get(index).regionID-1,newArea);
								defender.setImageOfRegion(Assets.BlueRegions.get(attacker.owner.currentRegions.get(index).regionID-1));
							
							}
							}
						defender.owner.currentHP+=14000;
						attacker.isCapital=false;
					}
					else {
						if(defender.owner.playerID==2) {
						UIObject newArea=(new UIImageRegion(attacker.corx,attacker.cory,attacker.width,attacker.height,Assets.YellowRegions,new ClickListener() {
							public void onClick() {
								if(attackClicked) {
									attackChoosen=true;
									System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
									attacker=regions.get(attacker.regionID-1);
								}
								else if(defendClicked) {
									defendChoosen=true;
									System.out.println("defender is "+regions.get(defender.regionID-1).toString());
									defender=regions.get(defender.regionID-1);
								}
							}
								
				},attacker.regionID-1));
						uiManagerG.setObject(attacker.regionID-1,newArea);
						defender.setImageOfRegion(Assets.YellowRegions.get(attacker.regionID-1));
						defender.owner.currentHP+=attacker.regionHP;
					}
					else if(defender.owner.playerID==3){
						UIObject newArea=(new UIImageRegion(attacker.corx,attacker.cory,attacker.width,attacker.height,Assets.BlueRegions,new ClickListener() {
							public void onClick() {
								if(attackClicked) {
									attackChoosen=true;
									System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
									attacker=regions.get(attacker.regionID-1);
								}
								else if(defendClicked) {
									defendChoosen=true;
									System.out.println("defender is "+regions.get(defender.regionID-1).toString());
									defender=regions.get(defender.regionID-1);
								}
							}
								
				},attacker.regionID-1));
						uiManagerG.setObject(attacker.regionID-1,newArea);
						defender.setImageOfRegion(Assets.BlueRegions.get(attacker.regionID-1));
						defender.owner.currentHP+=attacker.regionHP;
					}
					}
				}
			}
			attackChoosen=false;
			defendChoosen=false;
			player1turn=false;
			if(players.get(1).currentHP>0)
				player2turn=true;
			else {
				player2turn=false;
				player3turn=true;
			}

			warClicked=false;
			defenceRolled=false;
		}	
			}
	
	public void gameLoopPlayer2() {

		damage=attackpoint-defendpoint;
		dice.hitDmg(attacker, defender,damage);

		attackDice = false;
		defenceDice = false;
		if(damage>0)
		{
			damageIsDone=true;
			warClicked=false;
			defenceRolled=false;
			if(defender.regionHP<=0) {
				damageIsDone=false;
				conquer=true;
				warClicked=false;
				defenceRolled=false;
				defender.regionHP=500;
				if(defender.isCapital) {
					for(int index=0;index<defender.owner.currentRegions.size();index++) {				
							UIObject newArea=(new UIImageRegion(defender.owner.currentRegions.get(index).corx,defender.owner.currentRegions.get(index).cory,defender.owner.currentRegions.get(index).width,defender.owner.currentRegions.get(index).height,Assets.YellowRegions,new ClickListener() {
								public void onClick() {
									if(attackClicked) {
										attackChoosen=true;
										System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
										attacker=regions.get(defender.regionID-1);
									}
									else if(defendClicked) {
										defendChoosen=true;
										System.out.println("defender is "+regions.get(defender.regionID-1).toString());
										defender=regions.get(defender.regionID-1);
									}
								}
									
					},defender.owner.currentRegions.get(index).regionID-1));
							uiManagerG.setObject(defender.owner.currentRegions.get(index).regionID-1,newArea);
							defender.setImageOfRegion(Assets.YellowRegions.get(defender.owner.currentRegions.get(index).regionID-1));
							
					
						}
					attacker.owner.currentHP+=14000;
					defender.isCapital=false;
					
				}else {
					UIObject newArea=(new UIImageRegion(defender.corx,defender.cory,defender.width,defender.height,Assets.YellowRegions,new ClickListener() {
						public void onClick() {
							if(attackClicked) {
								attackChoosen=true;
								System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
								attacker=regions.get(defender.regionID-1);
							}
							else if(defendClicked) {
								defendChoosen=true;
								System.out.println("defender is "+regions.get(defender.regionID-1).toString());
								defender=regions.get(defender.regionID-1);
							}
						}
							
			},defender.regionID-1));
					uiManagerG.setObject(defender.regionID-1,newArea);
					defender.setImageOfRegion(Assets.YellowRegions.get(defender.regionID-1));
					attacker.owner.currentHP+=defender.regionHP;
				
				}
			}
		}
		else
		{
			damageIsDone=false;
			if(damage==0) {
				damageIsDone=false;
				defenceWin=false;
				tie=true;
			}
			else if(damage<0) {
				damageIsDone=false;
				tie=false;
				defenceWin=true;
				if(attacker.regionHP<=0) {
					unexpectedConquer=true;
					attacker.regionHP=500;
					if(attacker.isCapital) {
						for(int index=0;index<attacker.owner.currentRegions.size();index++) {
							if(defender.owner.playerID==1) {
								UIObject newArea=(new UIImageRegion(attacker.owner.currentRegions.get(index).corx,attacker.owner.currentRegions.get(index).cory,attacker.owner.currentRegions.get(index).width,attacker.owner.currentRegions.get(index).height,Assets.RedRegions,new ClickListener() {
									public void onClick() {
										if(attackClicked) {
											attackChoosen=true;
											System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
											attacker=regions.get(defender.regionID-1);
										}
										else if(defendClicked) {
											defendChoosen=true;
											System.out.println("defender is "+regions.get(defender.regionID-1).toString());
											defender=regions.get(defender.regionID-1);
										}
									}
										
						},attacker.owner.currentRegions.get(index).regionID-1));
								uiManagerG.setObject(attacker.owner.currentRegions.get(index).regionID-1,newArea);
								defender.setImageOfRegion(Assets.RedRegions.get(attacker.owner.currentRegions.get(index).regionID-1));
								
							}
							else if(defender.owner.playerID==3) {
								UIObject newArea=(new UIImageRegion(attacker.owner.currentRegions.get(index).corx,attacker.owner.currentRegions.get(index).cory,attacker.owner.currentRegions.get(index).width,attacker.owner.currentRegions.get(index).height,Assets.BlueRegions,new ClickListener() {
									public void onClick() {
										if(attackClicked) {
											attackChoosen=true;
											System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
											attacker=regions.get(defender.regionID-1);
										}
										else if(defendClicked) {
											defendChoosen=true;
											System.out.println("defender is "+regions.get(defender.regionID-1).toString());
											defender=regions.get(defender.regionID-1);
										}
									}
										
						},attacker.owner.currentRegions.get(index).regionID-1));
								uiManagerG.setObject(attacker.owner.currentRegions.get(index).regionID-1,newArea);
								defender.setImageOfRegion(Assets.BlueRegions.get(attacker.owner.currentRegions.get(index).regionID-1));
								
							}
							}
						defender.owner.currentHP+=14000;
					attacker.isCapital=false;
					}
					else {
					if(defender.owner.playerID==1) {
						UIObject newArea=(new UIImageRegion(attacker.corx,attacker.cory,attacker.width,attacker.height,Assets.RedRegions,new ClickListener() {
							public void onClick() {
								if(attackClicked) {
									attackChoosen=true;
									System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
									attacker=regions.get(defender.regionID-1);
								}
								else if(defendClicked) {
									defendChoosen=true;
									System.out.println("defender is "+regions.get(defender.regionID-1).toString());
									defender=regions.get(defender.regionID-1);
								}
							}
								
				},attacker.regionID-1));
						uiManagerG.setObject(attacker.regionID-1,newArea);
						defender.setImageOfRegion(Assets.RedRegions.get(attacker.regionID-1));
						defender.owner.currentHP+=attacker.regionHP;
					}
					else if(defender.owner.playerID==3) {
						UIObject newArea=(new UIImageRegion(attacker.corx,attacker.cory,attacker.width,attacker.height,Assets.BlueRegions,new ClickListener() {
							public void onClick() {
								if(attackClicked) {
									attackChoosen=true;
									System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
									attacker=regions.get(defender.regionID-1);
								}
								else if(defendClicked) {
									defendChoosen=true;
									System.out.println("defender is "+regions.get(defender.regionID-1).toString());
									defender=regions.get(defender.regionID-1);
								}
							}
								
				},attacker.regionID-1));
						uiManagerG.setObject(attacker.regionID-1,newArea);
						defender.setImageOfRegion(Assets.BlueRegions.get(attacker.regionID-1));
						defender.owner.currentHP+=attacker.regionHP;
					}
					}
				}
			}
			attackChoosen=false;
			defendChoosen=false;
			player2turn=false;
			if(players.get(2).currentHP>0)
				player3turn=true;
			else {
				player3turn=false;
				player1turn=true;
			}			warClicked = false;
			defenceRolled=false;
		}
			
			
	}
	
	public void gameLoopPlayer3() {

		damage=attackpoint-defendpoint;
		dice.hitDmg(attacker, defender,damage);

		attackDice = false;
		defenceDice = false;
		if(damage>0)
		{
			damageIsDone=true;
			warClicked=false;
			defenceRolled=false;
			if(defender.regionHP<=0) {
				damageIsDone=false;
				conquer=true;
				warClicked=false;
				defenceRolled=false;
				defender.regionHP=500;
				if(defender.isCapital) {
					for(int index=0;index<defender.owner.currentRegions.size();index++) {
							UIObject newArea=(new UIImageRegion(defender.owner.currentRegions.get(index).corx,defender.owner.currentRegions.get(index).cory,defender.owner.currentRegions.get(index).width,defender.owner.currentRegions.get(index).height,Assets.BlueRegions,new ClickListener() {
								public void onClick() {
									if(attackClicked) {
										attackChoosen=true;
										System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
										attacker=regions.get(defender.regionID-1);
									}
									else if(defendClicked) {
										defendChoosen=true;
										System.out.println("defender is "+regions.get(defender.regionID-1).toString());
										defender=regions.get(defender.regionID-1);
									}
								}
									
					},defender.owner.currentRegions.get(index).regionID-1));
							uiManagerG.setObject(defender.owner.currentRegions.get(index).regionID-1,newArea);
							defender.setImageOfRegion(Assets.RedRegions.get(defender.owner.currentRegions.get(index).regionID-1));
							
						}
					attacker.owner.currentHP+=14000;
					defender.isCapital=false;
				}else {

				UIObject newArea=(new UIImageRegion(defender.corx,defender.cory,defender.width,defender.height,Assets.BlueRegions,new ClickListener() {
					public void onClick() {
						if(attackClicked) {
							attackChoosen=true;
							System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
							attacker=regions.get(defender.regionID-1);
						}
						else if(defendClicked) {
							defendChoosen=true;
							System.out.println("defender is "+regions.get(defender.regionID-1).toString());
							defender=regions.get(defender.regionID-1);
						}
					}
						
		},defender.regionID-1));
				uiManagerG.setObject(defender.regionID-1,newArea);
				defender.setImageOfRegion(Assets.RedRegions.get(defender.regionID-1));
				attacker.owner.currentHP+=defender.regionHP;
				}
		}

		}
		else
		{
			damageIsDone=false;
			if(damage==0) {
				damageIsDone=false;
				defenceWin=false;
				tie=true;
			}
			else if(damage<0) {
				damageIsDone=false;
				tie=false;
				
				defenceWin=true;
				if(attacker.regionHP<=0) {
					unexpectedConquer=true;
					attacker.regionHP=500;
					if(attacker.isCapital) {
						
						for(int index=0;index<attacker.owner.currentRegions.size();index++) {
						if(defender.owner.playerID==1) {
							UIObject newArea=(new UIImageRegion(attacker.owner.currentRegions.get(index).corx,attacker.owner.currentRegions.get(index).cory,attacker.owner.currentRegions.get(index).width,attacker.owner.currentRegions.get(index).height,Assets.RedRegions,new ClickListener() {
								public void onClick() {
									if(attackClicked) {
										attackChoosen=true;
										System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
										attacker=regions.get(defender.regionID-1);
									}
									else if(defendClicked) {
										defendChoosen=true;
										System.out.println("defender is "+regions.get(defender.regionID-1).toString());
										defender=regions.get(defender.regionID-1);
									}
								}
									
					},attacker.owner.currentRegions.get(index).regionID-1));
							uiManagerG.setObject(attacker.owner.currentRegions.get(index).regionID-1,newArea);
							defender.setImageOfRegion(Assets.RedRegions.get(attacker.owner.currentRegions.get(index).regionID-1));
							

						}
						else if(defender.owner.playerID==2) {
							UIObject newArea=(new UIImageRegion(attacker.owner.currentRegions.get(index).corx,attacker.owner.currentRegions.get(index).cory,attacker.owner.currentRegions.get(index).width,attacker.owner.currentRegions.get(index).height,Assets.YellowRegions,new ClickListener() {
								public void onClick() {
									if(attackClicked) {
										attackChoosen=true;
										System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
										attacker=regions.get(defender.regionID-1);
									}
									else if(defendClicked) {
										defendChoosen=true;
										System.out.println("defender is "+regions.get(defender.regionID-1).toString());
										defender=regions.get(defender.regionID-1);
									}
								}
									
					},attacker.owner.currentRegions.get(index).regionID-1));
							uiManagerG.setObject(attacker.owner.currentRegions.get(index).regionID-1,newArea);
							defender.setImageOfRegion(Assets.YellowRegions.get(attacker.owner.currentRegions.get(index).regionID-1));
							
						}					
						}
						defender.owner.currentHP+=14000;
						attacker.isCapital=false;
					}
					else {
						attacker.setOwner(defender.owner);
						if(defender.owner.playerID==1) {
							UIObject newArea=(new UIImageRegion(attacker.corx,attacker.cory,attacker.width,attacker.height,Assets.RedRegions,new ClickListener() {
								public void onClick() {
									if(attackClicked) {
										attackChoosen=true;
										System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
										attacker=regions.get(defender.regionID-1);
									}
									else if(defendClicked) {
										defendChoosen=true;
										System.out.println("defender is "+regions.get(defender.regionID-1).toString());
										defender=regions.get(defender.regionID-1);
									}
								}
									
					},attacker.regionID-1));
							uiManagerG.setObject(attacker.regionID-1,newArea);
							defender.setImageOfRegion(Assets.RedRegions.get(attacker.regionID-1));
							defender.owner.currentHP+=attacker.regionHP;
						}
						else if(defender.owner.playerID==2) {
							UIObject newArea=(new UIImageRegion(attacker.corx,attacker.cory,attacker.width,attacker.height,Assets.YellowRegions,new ClickListener() {
								public void onClick() {
									if(attackClicked) {
										attackChoosen=true;
										System.out.println("attacker is "+regions.get(defender.regionID-1).toString());
										attacker=regions.get(defender.regionID-1);
									}
									else if(defendClicked) {
										defendChoosen=true;
										System.out.println("defender is "+regions.get(defender.regionID-1).toString());
										defender=regions.get(defender.regionID-1);
									}
								}
									
					},attacker.regionID-1));
							uiManagerG.setObject(attacker.regionID-1,newArea);
							defender.setImageOfRegion(Assets.YellowRegions.get(attacker.regionID-1));
							defender.owner.currentHP+=attacker.regionHP;
						}

					}
				}
			}
			attackChoosen=false;
			defendChoosen=false;
			warClicked = false;
			player3turn=false;
			if(players.get(0).currentHP>0)
				player1turn=true;
			else {
				player1turn=false;
				player2turn=true;
			}
			defenceRolled=false;
		}
		
			
		
	}
	
	public void addUIObject(int x, int y,int circX,int circY,int index) {
		if(regions.get(index).owner.playerID==1)
			uiManagerG.addObject(new UIImageRegion(x,y,circX,circY,Assets.RedRegions,new ClickListener() {
				public void onClick() {
						if(attackClicked) {
							attackChoosen=true;
							System.out.println("attacker is "+regions.get(index).toString());
							attacker=regions.get(index);
						}
						else if(defendClicked) {
							defendChoosen=true;
							System.out.println("defender is "+regions.get(index).toString());
							defender=regions.get(index);
						}
					}
						
		},index));
		else if(regions.get(index).owner.playerID==2)
			uiManagerG.addObject(new UIImageRegion(x,y,circX,circY,Assets.YellowRegions,new ClickListener() {
				public void onClick() {
					if(attackClicked) {
						attackChoosen=true;
						System.out.println("attacker is "+regions.get(index).toString());
						attacker=regions.get(index);
					}
					else if(defendClicked) {
						defendChoosen=true;
						System.out.println("defender is "+regions.get(index).toString());
						defender=regions.get(index);
					}
						
				}
		},index));
		else if(regions.get(index).owner.playerID==3)
			uiManagerG.addObject(new UIImageRegion(x,y,circX,circY,Assets.BlueRegions,new ClickListener() {
				public void onClick() {
					if(attackClicked) {
						attackChoosen=true;
						System.out.println("attacker is "+regions.get(index).toString());
						attacker=regions.get(index);
					}
					else if(defendClicked) {
						defendChoosen=true;
						System.out.println("defender is "+regions.get(index).toString());
						defender=regions.get(index);
					}
					
				}
		},index));
	}
}
