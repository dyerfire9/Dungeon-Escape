package utils;

import javafx.scene.image.Image;

public class PointImagePair {
    Image img;
    Point2D point;

    public PointImagePair(Point2D point, Image img) {
        this.point = point;
        this.img = img;
    }

    public Image getImg() {
        return img;
    }

    public Point2D getPoint() {
        return point;
    }
}
