package elements;

public class MovableBlock extends Element implements Movable {
    public MovableBlock(String sprite, int[] pos) {
        super(sprite, pos);
    }
    //TODO: MovableBlock should be "Pushed" when player moves to MovableBlock.
    @Override
    public void move() {

    }
}
