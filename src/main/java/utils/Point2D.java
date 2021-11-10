package utils;

public class Point2D {

    int x;
    int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point2D(int[] pair) {
        if (pair == null || pair.length != 2) {
            throw new IllegalArgumentException("Must pass in two integers to create Point2D object");
        }

        this.x = pair[0];
        this.y = pair[1];
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public int[] getPair() {
        return new int[]{this.x, this.y};
    }

    public static Point2D add(Point2D p1, Point2D p2) {
        return new Point2D(p1.getX() + p2.getX(), p1.getY() + p2.getY());
    }

    public static Point2D subtract(Point2D p1, Point2D p2) {
        return new Point2D(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }
}
