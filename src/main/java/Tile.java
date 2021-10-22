//TODO: is this still necessary?

public class Tile {
    private final boolean isTraversable;
    private String tileImage;

    public Tile(boolean isMovable, String tileImage){
        this.isTraversable = isMovable;
        this.tileImage = tileImage;
    }

    public boolean isTraversable() {
        return this.isTraversable;
    }

    @Override
    public String toString() {
        return this.tileImage;
    }
}