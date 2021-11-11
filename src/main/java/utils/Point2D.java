package utils;

/**
 * Class that represents an immutable 2-tuple of integer coordinates (that is, a point (x, y)).
 */
public class Point2D {

    private final int x;
    private final int y;

    /**
     * Constructs a Point2D from 2 ints.
     * @param x The first coordinate.
     * @param y The second coordinate.
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a Point2D from an int[2] array.
     * @param pair The integer array.
     */
    public Point2D(int[] pair) {
        if (pair == null || pair.length != 2) {
            throw new IllegalArgumentException("Must pass in two integers to create Point2D object");
        }

        this.x = pair[0];
        this.y = pair[1];
    }

    /**
     * Gets the first component.
     * @return The instance's first component.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets the second component.
     * @return The instance's second component.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Gets an int[] representation of the 2 components.
     * @return An int[] of length 2, whose elements are the first and second component.
     */
    public int[] getPair() {
        return new int[]{this.x, this.y};
    }

    /**
     * Performs vector addition on 2 Point2D instances.
     * @param p1 The first point.
     * @param p2 The second point.
     * @return A new Point2D instance with value (p1 + p2).
     */
    public static Point2D add(Point2D p1, Point2D p2) {
        return new Point2D(p1.getX() + p2.getX(), p1.getY() + p2.getY());
    }

    public static boolean equals(Point2D p1, Point2D p2) {
        return (p1.getX() == p2.getX()) & (p1.getY() == p2.getY());
    }
}
