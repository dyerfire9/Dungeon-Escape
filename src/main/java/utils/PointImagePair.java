package utils;

public class PointImagePair {
    String img;
    Point2D point;

    public PointImagePair(Point2D point, String img) {
        this.point = point;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public Point2D getPoint() {
        return point;
    }
}
