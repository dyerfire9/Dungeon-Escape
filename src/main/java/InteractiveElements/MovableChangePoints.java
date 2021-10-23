package InteractiveElements;

public class MovableChangePoints extends InteractiveElement implements Movable, ChangePoints{
    public MovableChangePoints(String sprite) {
        super(sprite);
    }

    @Override
    public int getChange() {
        return change;
    }
}
