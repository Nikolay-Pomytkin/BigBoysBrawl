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
    private Rectangle playerBox;
    public double x; //x coordinate
    public double y; //y coordinate
    private Rectangle hitBox;
    private final double punchPow; //These are constants that are
    private final double kickPow; // set after the constructor is
    private final double powPow; // called and determine power of moves 
    private double health;
    public boolean isDead = false;
    private long moveStop = 0;
    private boolean movingUp = false; //Used to jump up through grounds
    private int numJumps = 0;

    public Player(Image l, Image r, Image jl, Image jr, Image p, Image k, Image pow, Image ht, Image d, double x_1, double y_1, Rectangle hb, double pp, double kp, double powp, double hlth){
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
        health = hlth;
        
    }
    
    /*
    Name: Move
    Arguments: keyInput(s)
    Logic: Changes lateral and vertical movement according to key presed. 
    	   Hitbox changes with position. Naturally falling if not on ground.
    Return: void
    */
    
    //Need to implement collision detection
    public void jump(GameContainer gc){
        numJumps++;
    	movingUp = true;
    	int t = 1;
        double yI = y;
        while(/* Player is not colliding with ground*/){
            if(numJumps < 2 && gc.getInput().isKeyDown(Input.KEY_UP))
            	jump(gc);
        	int xDir = 0;
            if(gc.getInput().isKeyDown(Input.KEY_RIGHT))
                xDir = 1;
            else if(gc.getInput().isKeyDown(Input.KEY_LEFT));
                xDir = -1;
            x = x + xDir;
            y = -1 * Math.pow(0.2 * t, 2) + (3 * t) + yI;
            t++;
        }
        movingUp = false;
    }
    

    //MISSING FROM ALL ATTACK METHODS: CHECKING IF COLLISSION IS TRUE
    public Image punch(Player a){
        if(System.currentTimeMillis() - moveStop >= 500){ //500 is arbitrary
            a.gotHit(10 * punchPow); //10 is arbitrary
            return punch;
        }
        moveStop = System.currentTimeMillis();
        return null;
    }
    public Image kick(Player a){
        if(System.currentTimeMillis() - moveStop >= 750){ //750 is arbitrary
            a.gotHit(20 * kickPow); //20 is arbitrary
            return kick;
        }
        moveStop = System.currentTimeMillis();
        return null;
    }
    public Image power(Player a){
        if(System.currentTimeMillis() - moveStop >= 1200){ //1200 is arbitrary
            a.gotHit(25 * powPow); //25 is arbitrary
            return power;
        }
        moveStop = System.currentTimeMillis();
        return null;
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
    
    /*
    Name: Collide
    Arguments: Player attacking this player
    Logic: Checks if attacking player collides with this player and prevents player from moving farther
    Return: Boolean
    */
}
