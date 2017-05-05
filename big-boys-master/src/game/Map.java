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
    public boolean collideAll(Player p){
        for(Ground g : grounds){
            if(g.collide(p))
            	return true;
        }
        return false;
    }

    public void checkDead(){
        if(p1.x < boundary.x1 || p1.x < boundary.x2 || p1.y < boundary.y2)
            p1.die();
        if(p2.x < boundary.x1 || p2.x < boundary.x2 || p2.y < boundary.y2)
            p2.die();
    }
}