public class Tile {
    private final boolean is_movable;
    private String tile_image;

    public Tile(boolean is_movable, String tile_image){
        this.is_movable = is_movable;
        this.tile_image = tile_image;
    }

    public boolean isTraversable() {
        return this.is_movable;
    }

    @Override
    public String toString() {
        return this.tile_image;
    }
}