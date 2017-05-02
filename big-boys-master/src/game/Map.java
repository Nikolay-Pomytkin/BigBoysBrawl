package game;
import java.awt.Image;

public class Map {
    private final String name;
    private final Ground[] grounds;
    private final Player p1, p2;
    private final Rectangle boundary;
    private final Image background;
    public Map(String n, Ground[] g, Rectangle x, Player a, Player b, Image i){
        name = n;
        grounds = g;
        boundary = x;
        p1 = a;
        p2 = b;
        background = i;
    }
    public void collideAll(){
        for(Ground g : grounds){
            /*
            Need to code for collide method
            g.collide(p1);
            g.collide(p2);
            */
        }
    }

    public void checkDead(Player p){
        if(p.x < boundary.x1 || p.x < boundary.x2 || p.y < boundary.y2)
            p.die();
    }
}