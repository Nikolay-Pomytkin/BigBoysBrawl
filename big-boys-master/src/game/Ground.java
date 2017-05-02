package game;

public class Ground {
    private final Rectangle space;
    public Ground(double x, double x_2, double y, double y_2){
        space = new Rectangle(x, x_2, y, y_2);
    }
    /*
    Name: Collide
    Arguments: Character
    Logic: checks if player pos is in the same place as ground pos. If true, play movement is set to 0
    Returns: void
    */
}