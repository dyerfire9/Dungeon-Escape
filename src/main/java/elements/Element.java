package elements;

public class Element {
    // This is the base class for all objects to be seeded on the board.
    // TODO: could use image to represent an element.
    private String sprite;
    private int[] pos;


    public Element(String sprite, int[] pos){
        this.sprite = sprite;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return this.sprite;
    }

    public int[] getPos() { return this.pos;}
}
