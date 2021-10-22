package InteractiveElements;

public class InteractiveElement {
    // This is the base class for all objects to be seeded on the board.
    // TODO: could use image to represent an element.
    public String sprite;

    public InteractiveElement(String sprite){
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return this.sprite;
    }
}
