package elements;

import utils.Point2D;
import utils.PointImagePair;

public class Element {
    // This is the base class for all objects to be seeded on the board.
    private String sprite;
    private Point2D pos;


    public Element(String sprite, Point2D pos){
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
