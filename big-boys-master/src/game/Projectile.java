package game;
import java.awt.Image;

public class Projectile {
	private final int speed;
	private final int power;
	private Image image;
	private int x;
	private final int y;
	public Projectile(int s, int p, Image i, int x1, int y1){
		speed = s;
		power = p;
		image = i;
		x = x1;
		y = y1;
	}
	public void move(boolean isLeft){
		if(isLeft)
			x -= speed;
		else
			x += speed;
	}
	//p is the player that is getting hit by projectile
	public void collide(Player p) throws Throwable{
		if(p.collide(x, y)){
			p.gotHit(power);
			finalize();
		}
	}
	
}
