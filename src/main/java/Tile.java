public class Tile {
    private final boolean is_movable;
    private String sprite;

    public Tile(boolean is_movable, String sprite){
        this.is_movable = is_movable;
        this.tile_image = sprite;
    }

    public boolean isTraversable() {
        return this.is_movable;
    }

    @Override
    public String toString() {
        return this.tile_image;
    }
}