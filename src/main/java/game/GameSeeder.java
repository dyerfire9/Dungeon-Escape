package game;

import elements.types.PushableElement;
import utils.Point2D;

public class GameSeeder {
    private Game game;

    public GameSeeder(Game g) {
        this.game = g;
    }

    public void addGoal (Point2D pos) {
        this.game.getObjectManager().addGoal(pos);
    }

    public void addDownAlligatorDen(Point2D pos) {
        this.game.getObjectManager().addDownAlligatorDen(pos);
    }

    public void addUpAlligatorDen(Point2D pos) {
        this.game.getObjectManager().addUpAlligatorDen(pos);
    }

    public void addLeftAlligatorDen(Point2D pos) {
        this.game.getObjectManager().addLeftAlligatorDen(pos);
    }

    public void addRightAlligatorDen(Point2D pos) {
        this.game.getObjectManager().addRightAlligatorDen(pos);
    }

    public void addChasingElement(Point2D pos, int max_tick) {
        this.game.getObjectManager().addChasingElement(pos, max_tick);
    }

    public void addPortal(Point2D pos) {
        this.game.getObjectManager().addPortal(pos);
    }

    public void addRock(Point2D pos) {
        this.game.getObjectManager().addRock(pos);
    }

    public void addPushable(Point2D pos)  {
        if (PushableElement.instanceCounter <= 1) {
            this.game.getObjectManager().addPushable(pos);
        }
        else {
            System.out.println("Can't plant more PushableElements.");
        }
    }

}
