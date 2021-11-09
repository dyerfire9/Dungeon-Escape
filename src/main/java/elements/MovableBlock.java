package elements;

public class MovableBlock extends Element implements Movable {
    public MovableBlock(String sprite, int[] pos) {
        super(sprite, pos);
    }
    //TODO: MovableBlock should be "Pushed" when player moves to MovableBlock.
    //If player push the block from left setPos(a, b+1), and note that the pos of the element.getPos() cannot exceed the (board.getSize() - 1 - num of elements in the ROW/COL).
    @Override
    public void move() {

    }
}
