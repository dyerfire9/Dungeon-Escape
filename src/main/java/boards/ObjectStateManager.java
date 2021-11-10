package boards;

import elements.Element;
import elements.Movable;
import utils.Point2D;
import utils.PointImagePair;

import java.util.ArrayList;

public class ObjectStateManager {
    private ArrayList<Movable> boardObjects;

    public ObjectStateManager(){
        this.boardObjects = new ArrayList<Movable>();
    }

    public ObjectStateManager(ArrayList<Movable> boardObjects){
        this.boardObjects = boardObjects;
    }

    public void addObject(Movable object){
        boardObjects.add(object);
    }

    public void removeObject(Movable object){
        boardObjects.remove(object);
    }

    public ArrayList<PointImagePair> getPointImagePairs(){
        ArrayList<PointImagePair> collector = new ArrayList<>();
        for (Movable boardObject : this.boardObjects) {
            if (boardObject instanceof Element) {
                collector.add(((Element) boardObject).getPointImagePair());
            }
        }
        return collector;
    }

    public void updateObjects(){
        for (Movable boardObject : boardObjects) {
            boardObject.move();
        }
    }
}
