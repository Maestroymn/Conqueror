package dev.kaan.game.state;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.kaan.game.Handler;
import dev.kaan.game.gfx.Assets;
import dev.kaan.game.mainCodes.Player;
import dev.kaan.game.mainCodes.Region;
import dev.kaan.game.objects.Circle;
import dev.kaan.game.ui.ClickListener;
import dev.kaan.game.ui.UIImageButton;
import dev.kaan.game.ui.UIManager;

public class EndGameState extends State{
	private Handler handler;
	private boolean winner1,winner2,winner3;
	private UIManager uiManager;
	private State MenuState;
	public EndGameState(Handler handler,ArrayList<Region> regions,ArrayList<Circle> circles,ArrayList<Player> players,boolean player1W,boolean player2W,boolean player3W) {
		super(handler);
		this.handler=handler;
		winner1=player1W;
		winner2=player2W;
		winner3=player3W;
		uiManager=new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);
		
		uiManager.addObject(new UIImageButton(276,478,473,77,Assets.returnmenu,new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUiManager(null);
				MenuState=new MenuState(handler,regions,circles,players);
				State.setState(MenuState);
			}
	}
		));
		
		uiManager.addObject(new UIImageButton(443,567,139,77,Assets.exit,new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUiManager(null);
				System.exit(0);
			}
	}
		));
	}


	public void tick() {
		uiManager.tick();
		
	}


	public void render(Graphics g) {
		g.drawImage(Assets.endBack,0,0,null);
		if(winner1) {
			g.drawImage(Assets.player1W,262,229,null);
		}
		if(winner2) {
			g.drawImage(Assets.player2W,262,229,null);
		}
		if(winner3) {
			g.drawImage(Assets.player3W,262,229,null);
		}
		uiManager.render(g);
		
	}
	

}
