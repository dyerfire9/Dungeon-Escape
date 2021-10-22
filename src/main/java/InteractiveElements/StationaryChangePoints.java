package InteractiveElements;


public class StationaryChangePoints extends InteractiveElement implements ChangePoints {
    public StationaryChangePoints(String sprite) {
        super(sprite);
    }

    @Override
    public int getChange() {
        return change;
    }
}
