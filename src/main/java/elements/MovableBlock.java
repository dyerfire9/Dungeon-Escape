package elements;

import java.util.concurrent.ThreadLocalRandom;

public class MovableBlock extends Element implements Movable {
    public MovableBlock(String sprite, int[] pos) {
        super(sprite, pos);
    }

    @Override
    public void move() {
        int[] movement = new int[]{this.getPos()[0] + ThreadLocalRandom.current().nextInt(-1, 1),
                this.getPos()[1] + ThreadLocalRandom.current().nextInt(-1, 1)};
        this.setPos(movement);
    }
}
