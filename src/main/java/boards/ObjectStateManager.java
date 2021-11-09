package boards;

import elements.Element;
import elements.Movable;

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

    public ArrayList<String> getNames(){
        ArrayList<String> collector = new ArrayList<String>();
        for(int i = 0; i < this.boardObjects.size(); i++) {
            if (boardObjects.get(i) instanceof Element) {
                collector.add(((Element) (boardObjects.get(i))).toString());
            }
        }
        return collector;
    }

    public ArrayList<int[]> getCoords(){
        ArrayList<int[]> collector = new ArrayList<int[]>();
        for(int i = 0; i < this.boardObjects.size(); i++) {
            if (boardObjects.get(i) instanceof Element) {
                collector.add(((Element) (boardObjects.get(i))).getPos());
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
