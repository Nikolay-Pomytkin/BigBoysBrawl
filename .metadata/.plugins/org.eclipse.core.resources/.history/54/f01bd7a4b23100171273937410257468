package game;

public class Rectangle {
    public int x1; //smaller
    public int x2; //larger
    public int y1; //smaller
    public int y2; //larger
    
    public Rectangle(int x, int x_2, int y, int y_2){
        x1 = x;
        x2 = x_2;
        y1 = y;
        y2 = y_2;
    }
    public void move(int deltaX, double deltaY){
        x1 += deltaX;
        x2 += deltaX;
        y1 += (int)(deltaY);
        y2 += (int)(deltaY);
    }
    public boolean isIn(int x, int y){
    	if(x >= x1 && x <= x2 && y >= y1 && y <= y2)
    		return true;
    	return false;
    }
}

