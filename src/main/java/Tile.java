public class Tile {
    private final boolean isMovable;
    private String tileImage;

    public Tile(boolean isMovable, String tileImage){
        this.isMovable = isMovable;
        this.tileImage = tileImage;
    }

    public boolean isMovable() {
        return this.isMovable;
    }

    @Override
    public String toString() {
        return this.tileImage;
    }
}