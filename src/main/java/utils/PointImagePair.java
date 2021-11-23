package utils;

public class PointImagePair {
    EnumsForSprites img;
    Point2D point;

    /**
     * A constructor for the PointImagePair class.
     * @param point a location on the board, represented by a Point2D object composed of 2 integer coordinates
     * @param img a representation of the element present at that location
     */
    public PointImagePair(Point2D point, EnumsForSprites img) {
        this.point = point;
        this.img = img;
    }

    /**
     * Gets the representation of an element
     * @return the representation of an element, currently a String, to be mapped into an Image by the GraphicsLoader
     */
    public EnumsForSprites getImg() {
        return img;
    }

    /**
     * @return a on the board, represented by a Point2D object composed of 2 integer coordinates
     */
    public Point2D getPoint() {
        return point;
    }
}
