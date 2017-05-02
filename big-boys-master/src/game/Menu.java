package game;

import org.newdawn.slick.*;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState{
	
	// Naming logo and menubar images and mouse positions 
	Image logo, menuBar;
	int xpos;
	int ypos;
	
	public Menu(int state) throws SlickException{

	}
	
	// Initializing images
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		menuBar = new Image("res/backgrounds/menuBarNew.jpeg");
		logo = new Image("res/backgrounds/logo.png");
		AudioLoader al = new AudioLoader();
	}
	
	// Draw images
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		menuBar.draw(0, 0);
		g.drawImage(logo, 800, 40);
	}

	// Game loop
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// Get mouse positions
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		//Check if user clicks help button
		if(ypos > 30 && ypos < 70 && xpos > 540 && xpos < 785){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(3, new FadeOutTransition(), new FadeInTransition());
			}
		}
		//Check if user clicks exit button
		if(ypos > 30 && ypos < 70 && xpos >800 && xpos < 1040){
			if(Mouse.isButtonDown(0)){
				System.exit(0);
			}
		}
		//Check if user clicks credits button
		if(ypos > 30 && ypos < 70 && xpos > 290 && xpos < 530){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(2, new EmptyTransition(), new BlobbyTransition());
			}
		}
		//Check if user clicks play button
		if(ypos > 30 && ypos < 70 && xpos > 30 && xpos < 275){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(4, new EmptyTransition(), new HorizontalSplitTransition());
			}
		}
	}
	// Get State ID
	public int getID() {
		return 0;
	}

}
