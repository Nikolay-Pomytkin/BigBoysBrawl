package game;

import java.awt.Image;
import org.newdawn.slick.*;
/**
 *
 * @author user
 */
public class Player {
    private final Image left;
    private final Image right;
    private final Image jumpLeft;
    private final Image jumpRight;
    private final Image punch;
    private final Image kick;
    private final Image power;
    private final Image hit;
    private final Image death;
    public int x; //x coordinate
    public int y; //y coordinate
    private Rectangle hitBox;
    private final int punchPow; //These are constants that are
    private final int kickPow; // set after the constructor is
    private final int powPow; // called and determine power of moves 
    private int health;
    private int speed;
    public boolean isDead = false;
    private long moveStop = 0; //used to determine time between moves
    public boolean movingUp = false; //Used to jump up through grounds
    private int numJumps = 0;
    private final int punchDist; //How long arm is. Used for collision
    private final int kickDist; //How long leg is. Used for collision
    private final int legFistDist; //Vertical distance (y distance) between fist and leg
    private boolean movingLeft = false;
    public final int chestFootDist; //Vertical distance (y distance) between the variable y and the feet of the player
    private Map map;

    public Player(Image l, Image r, Image jl, Image jr, Image p, Image k, Image pow, Image ht, Image d, int x_1, int y_1, Rectangle hb, int pp, int kp, int powp, int s, int hlth, int pD, int kD, int lF, int cF, Map m){
        left = l;
        right = r;
        jumpLeft = jl;
        jumpRight = jr;
        punch = p;
        kick = k;
        power = pow;
        hit = ht;
        death = d;
        x = x_1;
        y = y_1;
        hitBox = hb;
        punchPow = pp;
        kickPow = kp;
        powPow = powp;
        speed = s;
        health = hlth;
        punchDist = pD;
        kickDist = kD;
        legFistDist = lF;
        chestFootDist = cF;
        map = m;
    }

    public void move(GameContainer gc){
    	int xDir = 0;
        if(gc.getInput().isKeyDown(Input.KEY_RIGHT)){
            xDir = speed;
            movingLeft = false;
        }
        else if(gc.getInput().isKeyDown(Input.KEY_LEFT)){
            xDir = -1 * speed;
            movingLeft = true;
        }
        x = x + xDir;
        hitBox.move(xDir, 0);
        if(!(map.collideAll(this))){
        	//Player naturally falling
        	y--; //should be changed to a value greater than 1
        	hitBox.move(0, -1);
        }
    }
    
    //Need to implement collision detection
    public void jump(GameContainer gc){
        numJumps++;
    	movingUp = true;
    	int t = 0;
        double yI = y;
        while(!(map.collideAll(this))){
            if(numJumps < 2 && gc.getInput().isKeyDown(Input.KEY_UP))
            	jump(gc);
            else{
	        	int xDir = 0;
	        	if(gc.getInput().isKeyDown(Input.KEY_RIGHT)){
	                xDir = speed;
	                movingLeft = false;
	            }
	            else if(gc.getInput().isKeyDown(Input.KEY_LEFT)){
	                xDir = -1 * speed;
	                movingLeft = true;
	            }
	            x = x + xDir;
	            y = (int)(-1 * Math.pow(0.2 * t, 2) + (3 * t) + yI);
	            t++;
	            hitBox.move(xDir, -1 * Math.pow(0.2 * t, 2) + (3 * t));
	        }
        }
        movingUp = false;
        numJumps = 0;
    }
    

    //MISSING FROM ALL ATTACK METHODS: CHECKING IF COLLISSION IS TRUE
    public Image punch(Player a){
    	int pD = punchDist;
    	if(movingLeft)
    		pD *= -1;
    	//Show animation here
        if(a.collide(x + pD, y) && System.currentTimeMillis() - moveStop >= 500){ //500 is arbitrary
            a.gotHit(10 * punchPow); //10 is arbitrary
            return punch;
        }
        moveStop = System.currentTimeMillis();
        return left; //figure out what direction to return
    }
    public Image kick(Player a){
    	int kD = kickDist;
    	if(movingLeft)
    		kD *= -1;
    	//Show animation here
        if(a.collide(x + kD, y-legFistDist) && System.currentTimeMillis() - moveStop >= 750){ //750 is arbitrary
            a.gotHit(20 * kickPow); //20 is arbitrary
            return kick;
        }
        moveStop = System.currentTimeMillis();
        return left; //figure out what direction to return
    }
    public Image power(Player a){
    	//Show animation here
        if(System.currentTimeMillis() - moveStop >= 1200){ //1200 is arbitrary
            a.gotHit(25 * powPow); //25 is arbitrary
            return power;
        }
        moveStop = System.currentTimeMillis();
        return left; //figure out what direction to return
        
    }
    
    
    public Image gotHit(double h){
        health -= h;
        if(h <= 0){
            return die();
        }
        return hit;
    }
    public Image die(){
        isDead = true;
        return death;
    }
    
    //Arguments taken are coordinates of punch/kick
    public boolean collide(int x, int y){
    	if(hitBox.isIn(x, y))
    		return true;
    	return false;
    }
}
