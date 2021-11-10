package elements;

import javafx.scene.image.Image;

public class Tile {
    boolean isTraversable;
    private Image sprite;

    public Tile(Boolean isTraversable) {
        this.isTraversable = isTraversable;
        this.sprite = new Image("file:src/main/assets/tiles/cobble_blood1.png");
    }

    public boolean isTraversable() {
     return this.isTraversable;
    }

    public Image getSprite() {
        return this.sprite;
    }
}
