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
    public double x; //x coordnate
    public double y; //y coordnate
    private Rectangle hitBox;
    private final double punchPow; //These are constants that are
    private final double kickPow; // set after the construnctor is
    private final double powPow; // called and determine power of moves 
    private double health;
    public boolean isDead = false;
    private long moveStop = 0;

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
    Logic: Changes lateral and vertical movement according to key presed. Diagonal jumping is allowed
    Return: void
    */
    
    //Need to implement collision detection
    public void jump(GameContainer gc){
        int t = 1;
        double yI = y;
        while(/* Player is not colliding with ground*/){
            int xDir = 0;
            if(gc.getInput().isKeyDown(Input.KEY_RIGHT))
                xDir = 1;
            else if(gc.getInput().isKeyDown(Input.KEY_LEFT));
                xDir = -1;
            x = x + xDir;
            y = -1 * Math.pow(0.2 * t, 2) + (3 * t) + yI;
            t++;
        }
    }
    

    //MISSING FROM ALL ATTACK METHODS: CHECKING IF COLLISSION IS TRUE
    public Image punch(Player a){
        if(System.currentTimeMillis() - moveStop >= 500){
            a.gotHit(10 * punchPow);
            return punch;
        }
        moveStop = System.currentTimeMillis();
        return null;
    }
    public Image kick(Player a){
        if(System.currentTimeMillis() - moveStop >= 750){
            a.gotHit(20 * kickPow);
            return kick;
        }
        moveStop = System.currentTimeMillis();
        return null;
    }
    public Image power(Player a){
        if(System.currentTimeMillis() - moveStop >= 1200){
            a.gotHit(10 * powPow);
            return power;
        }
        moveStop = System.currentTimeMillis();
        return null;
    }
    
    
    public Image gotHit(double h){
        health -= h;
        if(h <= 0){
            isDead = true;
            return death;
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
    Logic: Checks if attacking player collides with this player
    Return: Boolean
    */
}
