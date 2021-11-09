package elements;
import java.util.concurrent.ThreadLocalRandom;

public class MovableChangePoints extends Element implements Movable, ChangePoints{
    public MovableChangePoints(String sprite, int[] pos) {
        super(sprite, pos);
    }

    @Override
    public int getChange() {
        return change;
    }

    @Override
    //TODO: What if int[] is an invalid tile?
    public void move() {
        int[] movement = new int[]{this.getPos()[0] + ThreadLocalRandom.current().nextInt(-1, 1),
                this.getPos()[1] + ThreadLocalRandom.current().nextInt(-1, 1)};
        this.setPos(movement);
    }
}
