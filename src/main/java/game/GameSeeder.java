package game;

import elements.types.PushableElement;
import utils.EnumsForSprites;
import utils.Point2D;

public class GameSeeder {
    private Game game;

    /**
     * A contructor for this class.
     * @param g the Game object to which this GameSeeder applies.
     */
    public GameSeeder(Game g) {
        this.game = g;
    }

    /**
     * A wrapper method for this GameSeeder to add a Goal object on its Game.
     * @param pos the position on the Game's board where the element is to be planted
     */
    public void addGoal (Point2D pos) {
        this.game.getObjectManager().addGoal(pos);
    }

    /**
     * A wrapper method for this GameSeeder to add a downward-shooting AlligatorDen object to its Game.
     * @param pos the position on the Game's board where the element is to be planted
     */
    public void addDownAlligatorDen(Point2D pos) {
        this.game.getObjectManager().addDownAlligatorDen(pos);
    }


    /**
     * A wrapper method for this GameSeeder to add a upward-shooting AlligatorDen object to its Game.
     * @param pos the position on the Game's board where the element is to be planted
     */
    public void addUpAlligatorDen(Point2D pos) {
        this.game.getObjectManager().addUpAlligatorDen(pos);
    }


    /**
     * A wrapper method for this GameSeeder to add a left-shooting AlligatorDen object to its Game.
     * @param pos the position on the Game's board where the element is to be planted
     */
    public void addLeftAlligatorDen(Point2D pos) {
        this.game.getObjectManager().addLeftAlligatorDen(pos);
    }


    /**
     * A wrapper method for this GameSeeder to add a right-shooting AlligatorDen object to its Game.
     * @param pos the position on the Game's board where the element is to be planted
     */
    public void addRightAlligatorDen(Point2D pos) {
        this.game.getObjectManager().addRightAlligatorDen(pos);
    }


    /**
     * A wrapper method for this GameSeeder to add a ChasingElement to its Game.
     * @param pos the position on the Game's board where the element is to be planted
     */
    public void addChasingElement(Point2D pos, int max_tick) {
        this.game.getObjectManager().addChasingElement(pos, max_tick);
    }

    /**
     * A wrapper method for this GameSeeder to add a Portal to its Game.
     * @param pos the position on the Game's board where the element is to be planted
     */

    public void addPortal(Point2D pos) {
        this.game.getObjectManager().addPortal(pos);
    }

    /**
     * A wrapper method for this GameSeeder to add a Pushable object to its Game.
     * @param pos the position on the Game's board where the element is to be planted
     */
    public void addPushable(Point2D pos)  {
        this.game.getObjectManager().addPushable(pos);
    }


    /**
     * A wrapper method for this GameSeeder to add a Rock object to its Game.
     * @param pos the position on the Game's board where the element is to be planted
     */
    public void addRock(Point2D pos) {
        this.game.getObjectManager().addRock(pos);
    }

    public void changePlayerStartPos(Point2D pos) {this.game.changePlayerStartPos(pos);}


    /**
     * Adds objects to the game board by type and at a certain position.
     * @param element the sprite representation of the element to be added
     * @param mousePos the position where the element is to be added on the board
     */
    public void add(EnumsForSprites element, Point2D mousePos) {
        if (element == EnumsForSprites.GOAL) {
            this.addGoal(mousePos);
        } else if (element == EnumsForSprites.ALLIGATOR_DEN_UP) {
            this.addUpAlligatorDen(mousePos);
        } else if (element == EnumsForSprites.ALLIGATOR_DEN_DOWN) {
            this.addDownAlligatorDen(mousePos);
        } else if (element == EnumsForSprites.ALLIGATOR_DEN_LEFT) {
            this.addLeftAlligatorDen(mousePos);
        } else if (element == EnumsForSprites.ALLIGATOR_DEN_RIGHT) {
            this.addRightAlligatorDen(mousePos);
        } else if (element == EnumsForSprites.PORTAL) {
            this.addPortal(mousePos);
        } else if (element == EnumsForSprites.CHASER) {
            this.addChasingElement(mousePos, 15);
        } else if (element == EnumsForSprites.ROCK && this.game.checkPortals()) {
            this.addRock(mousePos);
        } else if (element == EnumsForSprites.PUSHABLE_ELEMENT) {
            this.addPushable(mousePos);
        } else if (element == EnumsForSprites.PLAYER) {
            this.changePlayerStartPos(mousePos);
        }
        else {
            System.out.printf("No implementation for placing element '%s'.%n", element);
        }
    }

}
