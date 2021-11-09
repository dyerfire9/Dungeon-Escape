package elements;

public class MovableBlock extends Element implements Movable {
    public MovableBlock(String sprite, int[] pos) {
        super(sprite, pos);
    }
    //TODO: MovableBlock should be "Pushed" when player moves to MovableBlock.
    //If player push the block from left setPos(a+1, b), and note that
    @Override
    public void move() {

    }
}
