package elements;


public class Tile {
    boolean isTraversable;
    private String sprite;

    public Tile(Boolean isTraversable) {
        this.isTraversable = isTraversable;
        if (isTraversable){
            this.sprite = "isTraversable";
        }
        else {
            this.sprite = "notTraversable";
        }
    }

    public boolean isTraversable() {
     return this.isTraversable;
    }

    public String getSprite() {
        return this.sprite;
    }
}
