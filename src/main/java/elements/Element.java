package elements;

import javafx.scene.image.Image;
import utils.Point2D;
import utils.PointImagePair;

public class Element {
    // This is the base class for all objects to be seeded on the board.
    // TODO: could use image to represent an element.
    private Image sprite;
    private Point2D pos;


    public Element(Image sprite, Point2D pos){
        this.sprite = sprite;
        this.pos = pos;
    }

    public PointImagePair getPointImagePair() {
        return new PointImagePair(this.pos, this.sprite);
    }

    public Point2D getPos() {
        return this.pos;
    }

    public void setPos(Point2D newPos) {
        this.pos = newPos;
    }
}
