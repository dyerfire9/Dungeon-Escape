package InteractiveElements;

public class InteractiveElement {
    // Consider the construction of Player. This is the base class for all objects to be seeded on the board.

    public int[] pos;
    private final String sprite;

    public InteractiveElement(int[] pos, String sprite){
        this.pos = pos;
        this.sprite = sprite;
    }

    public int[] getPos(){
        return pos;
    }


    @Override
    public String toString() {
        return this.sprite;
    }
}
