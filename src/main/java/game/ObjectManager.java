package game;

import elements.*;
import elements.Element;
import game.PlayerState;
import utils.Point2D;
import utils.PointImagePair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class ObjectManager implements Serializable {
    private ArrayList<Element> boardObjects;
    private int bound;

    /**
     * A constructor for ObjectManager class.
     * @param bound the size of the board - 1, which is the size of the area where the elements can reside.
     */
    public ObjectManager(int bound){
        this.boardObjects = new ArrayList<Element>();
        this.bound = bound;

    }

    /**
     * Another constructor for the ObjectManager class, which creates an ObjectManager from a list of existing elements.
     * Used to reload the game.
     * @param boardObjects a list of existing elements
     * @param bound the size of the board - 1, which is the size of the area where the elements can reside.
     */
    public ObjectManager(ArrayList<Element> boardObjects, int bound){
        this.boardObjects = boardObjects;
        this.bound = bound;
    }

    /**
     * Add new elements to the board, collected and managed by the objectManager.
     * @param object new element to be added
     */
    public void addObject(Element object){
        boardObjects.add(object);
    }

    // Methods to enable calls from gameMaker
    // TODO: add more or configure with gameMaker

    /**
     * A method to place, specifically, an AlligatorDen that shoots alligators only to the right on the board. This
     * method will link with gameMaker's "elements menu," so that the user can choose a specific type of element to
     * plant at a specific location on the board.
     * @param pos where the new AlligatorDen is placed on the board.
     */
    public void addRightAlligatorDen(Point2D pos) {
        this.addObject(new AlligatorDen("alligatorDen", pos, new Point2D(1,0) ,120, bound));
    }


    /**
     * A method to place left-shooting AlligatorDens.
     * @param pos where the new AlligatorDen is placed on the board
     */
    public void addLeftAlligatorDen(Point2D pos) {
        this.addObject(new AlligatorDen("alligatorDen", pos, new Point2D(-1,0) ,120, bound));
    }

    /**
     * A method to place upward-shooting AlligatorDens.
     * @param pos where the new AlligatorDen is placed on the board
     */
    public void addUpAlligatorDen(Point2D pos) {
        this.addObject(new AlligatorDen("alligatorDen", pos, new Point2D(0,-1) ,120, bound));
    }

    /**
     * A method to place downward-shooting AlligatorDens.
     * @param pos where the new AlligatorDen is placed on the board
     */
    public void addDownAlligatorDen(Point2D pos) {
        this.addObject(new AlligatorDen("alligatorDen", pos, new Point2D(0, 1) ,120, bound));
    }

    /**
     * A method to place a Goal element on the board. When Player reaches the Goal, the Player wins the game.
     * @param pos location where the Goal element is placed on the board
     */
    public void addGoal(Point2D pos) {
        this.addObject(new Goal("Goal", pos));
    }

    public void addTeleporter(Point2D pos) {
        this.addObject(new Teleporter("Teleporter", pos));
    }



    /**
     * A method to remove elements from the board, which is managed by the board's objectManager.
     * @param object the element to be deleted
     */

    public void removeObject(Element object){
        boardObjects.remove(object);
    }


    /**
     * A getter method to collect and access a mapping between the location and the string representation of all objects
     * currently on the board.
     * @return the collection of every object's location and corresponding string representation.
     */
    public ArrayList<PointImagePair> getPointImagePairs(){
        ArrayList<PointImagePair> collector = new ArrayList<>();
        for (Element boardObject : this.boardObjects) {
                collector.add(boardObject.getPointImagePair());
        }
        return collector;
    }

    /**
     * Updates the content of the ObjectManager, removing elements that have gone off the screen and adding elements
     * that have been generated.
     */
    public void updateObjects(){
        HashSet<Element> objectsToRemove = new HashSet<>();
        HashSet<Element> objectsToAdd = new HashSet<>();

        for (Element boardObject : boardObjects) {

            if (boardObject instanceof MovableElement) {
                boolean result = ((MovableElement) boardObject).processTick();
                if (!result) {
                    objectsToRemove.add(boardObject);
                }
            }
            else if (boardObject instanceof Generator) {
                Element elementToAdd = ((Generator) boardObject).placeElement();
                if (elementToAdd != null) {
                    objectsToAdd.add(elementToAdd);
                }

            }
        }

        // Remove objects that have gone offscreen
        for (Element element: objectsToRemove) {
            this.removeObject(element);
        }

        //Add any generated objects
        for (Element element: objectsToAdd){
            this.addObject(element);
        }
    }


    /**
     * If a Player steps onto the same location as an Element, check to see if the Element can affect the Player's
     * PlayerState; if so, update PlayerState.
     *
     * @param playerPosition the Player's current position
     * @param playerState the Player's playerState, currently including points, temporary invincibility after
     *                    encountering an element, and winning status.
     * @return
     */
    public PlayerState modifyPlayerState(Point2D playerPosition, PlayerState playerState) {
        ArrayList<Element> portals = new ArrayList<>();

        for (Element boardObject : boardObjects) {
            if ((boardObject instanceof Interactable) & Point2D.equals(boardObject.getPos(), playerPosition)) {
                playerState = ((Interactable) boardObject).changePlayerState(playerState);
            }
            if ((boardObject instanceof Teleportable)) {
                portals.add(boardObject);
            }
        }

        if (Point2D.equals(playerPosition, portals.get(0).getPos())){
            //playerState = ((Teleportable) portals.get(0)).changePlayerPosition(playerState);
            playerState = ((Teleportable) portals.get(0)).changePlayerPosition(playerState, portals.get(1).getPos());

        }
        else if (Point2D.equals(playerPosition, portals.get(1).getPos())){
            //playerState = ((Teleportable) portals.get(1)).changePlayerPosition(playerState);
            playerState = ((Teleportable) portals.get(1)).changePlayerPosition(playerState, portals.get(0).getPos());

        }

        return playerState;
    }


}
