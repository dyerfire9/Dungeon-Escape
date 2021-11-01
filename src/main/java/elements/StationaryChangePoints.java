package elements;


public class StationaryChangePoints extends Element implements ChangePoints {
    public StationaryChangePoints(String sprite, int[] pos) {
        super(sprite, pos);
    }

    @Override
    public int getChange() {
        return change;
    }
}
