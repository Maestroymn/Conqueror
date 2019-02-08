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

public class RulesState extends State{
	private Handler handler;
	private UIManager uiManager;
	private MenuState menuState;
	
	public RulesState(Handler handler,ArrayList<Region> regions,ArrayList<Circle> circles,ArrayList<Player> players) {
		super(handler);
		this.handler=handler;
		uiManager=new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);
		
		uiManager.addObject(new UIImageButton(395,571,209,110,Assets.backButton,new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUiManager(null);
				menuState=new MenuState(handler,regions,circles,players);
				State.setState(menuState);
			}
	}
		));
	
	}


	public void tick() {
		uiManager.tick();
		
	}


	public void render(Graphics g) {
		g.drawImage(Assets.rules, 15,70, null);
		uiManager.render(g);
		
	}
}
