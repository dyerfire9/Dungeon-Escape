package elements;


import java.io.Serializable;

public class Tile implements Serializable {
    boolean isTraversable;
    private String sprite;

    /**
     * A constructor for the Tile class.
     * @param isTraversable indicates whether a Player can move onto this element's position on the board.
     */
    public Tile(Boolean isTraversable) {
        this.isTraversable = isTraversable;
        if (isTraversable){
            this.sprite = "isTraversable";
        }
        else {
            this.sprite = "notTraversable";
        }
    }

    /**
     * @return whether a Player can move onto this element's position
     */
    public boolean isTraversable() {
     return this.isTraversable;
    }

    /**
     * @return this element's representation
     */
    public String getSprite() {
        return this.sprite;
    }
}
