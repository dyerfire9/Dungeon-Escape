package game;

import utils.Point2D;

public class GameSeeder {
    private Game game;

    public GameSeeder(Game g) {
        this.game = g;
    }

    public void addGoal (Point2D pos) {
        this.game.getBoard().getObjectManager().addGoal(pos);
    }

    public void addDownAlligatorDen(Point2D pos) {
        this.game.getBoard().getObjectManager().addDownAlligatorDen(pos);
    }

    public void addRightAlligatorDen(Point2D pos) {
        this.game.getBoard().getObjectManager().addRightAlligatorDen(pos);
    }

    public void addChasingElement(Point2D pos) {
        this.game.getBoard().getObjectManager().addChasingElement(pos);
    }

}
