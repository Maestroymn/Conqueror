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

public class MenuState extends State {
	private Handler handler;
	private UIManager uiManager;
	private State capitalState;
	private State rulesState;
	public MenuState(Handler handler,ArrayList<Region> regions,ArrayList<Circle> circles,ArrayList<Player> players) {
		super(handler);
		this.handler=handler;
		uiManager=new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);
		
		uiManager.addObject(new UIImageButton(376,412,275,100,Assets.startButtons,new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUiManager(null);
				capitalState=new CapitalState(handler,regions,circles,players);
				State.setState(capitalState);
			}
	}
		));
		uiManager.addObject(new UIImageButton(373,512,279,90,Assets.ruleButtons,new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUiManager(null);
				rulesState=new RulesState(handler,regions,circles,players);
				State.setState(rulesState);
			}
	}
		));
		
		uiManager.addObject(new UIImageButton(394,610,239,90,Assets.exitButtons,new ClickListener() {
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
		//g.setColor(Color.LIGHT_GRAY);
		//g.fillRect(0,0,handler.getWidth(),handler.getHeight());
		Assets.menuSheets();
		g.drawImage(Assets.crossedSwords,363,24,null);
		g.drawImage(Assets.title,189,309,null);
		uiManager.render(g);
		
	}
	
	
}
