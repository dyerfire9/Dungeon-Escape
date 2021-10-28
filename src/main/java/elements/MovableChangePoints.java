package elements;

public class MovableChangePoints extends Element implements Movable, ChangePoints{
    public MovableChangePoints(String sprite, int[] pos) {
        super(sprite, pos);
    }

    @Override
    public int getChange() {
        return change;
    }

    @Override
    public void move() {

    }
}
