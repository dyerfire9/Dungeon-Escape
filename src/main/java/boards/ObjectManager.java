package boards;

import elements.*;
import elements.Element;
import utils.PlayerState;
import utils.Point2D;
import utils.PointImagePair;

import java.util.ArrayList;
import java.util.HashSet;

public class ObjectManager {
    private ArrayList<Element> boardObjects;
    private int bound;

    public ObjectManager(int bound){
        this.boardObjects = new ArrayList<Element>();
        this.bound = bound;

        System.out.println(this.bound);
        this.addObject(
                new AlligatorDen("alligatorDen",
                        new Point2D(2, 2),
                        new Point2D(0, 1),
                        120,
                        this.bound
                        )
        );
    }

    public ObjectManager(ArrayList<Element> boardObjects, int bound){
        this.boardObjects = boardObjects;
        this.bound = bound;
    }

    public void addObject(Element object){
        boardObjects.add(object);
    }

    public void removeObject(Element object){
        boardObjects.remove(object);
    }

    public ArrayList<PointImagePair> getPointImagePairs(){
        ArrayList<PointImagePair> collector = new ArrayList<>();
        for (Element boardObject : this.boardObjects) {
                collector.add(boardObject.getPointImagePair());
        }
        return collector;
    }

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
    public PlayerState modifyPlayerState(Point2D playerPosition, PlayerState playerState) {
        for (Element boardObject : boardObjects) {
            if ((boardObject instanceof Interactable) & Point2D.equals(boardObject.getPos(), playerPosition)) {
                playerState = ((Interactable) boardObject).changePlayerState(playerState);
            }
        }
        return playerState;
    }
}
