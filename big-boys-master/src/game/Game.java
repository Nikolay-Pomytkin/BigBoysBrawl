package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.*;

public class Game extends StateBasedGame{
	
	// Name of game in title bar
	public static final String gameName = "Big Boys Brawl";
	
	// List of states:
	public static final int menu = 0;

	
	// Creating memory allocation for states
	public Game(String gameName) throws SlickException{
		super(gameName);
		this.addState(new Menu(menu));
	}
	
	// Initializing States into game
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.enterState(menu);
	}
	
	// Main Game
	public static void main(String[] args) {
		AppGameContainer appGC;
		try {
			appGC = new AppGameContainer(new Game(gameName));
			appGC.setDisplayMode(1080, 720, false);;
			appGC.start();
		} catch(SlickException e){
			e.printStackTrace();
		}
	}
}
