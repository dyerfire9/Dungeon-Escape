package boards;

import elements.Element;
import elements.Movable;

public class Board {
    private final int size;
    private Object[][] board;
    private ObjectStateManager objectStateManager;

    public Board(int size) {
        this.size = size;
        this.board = new Object[size][size];
        this.objectStateManager = new ObjectStateManager();
    }

    public int getSize() {
        return this.size;
    }

    public Object[][] getBoard() {
        return this.board;
    }

    public Object getElement(int[] pos) {
        return this.board[pos[0]][pos[1]];
    }

    public void setElement(int[] pos, Element e) {
        this.board[pos[0]][pos[1]] = e;
    }

    public void addMovableObject(Movable object){
        objectStateManager.addObject(object);
    }

    public void updateBoard(){
        objectStateManager.updateObjects();
    }

}

