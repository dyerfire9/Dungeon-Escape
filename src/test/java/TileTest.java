import org.junit.*;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class TileTest {
    @Test(timeout = 50)
    public void TestTileToString_1() {
        Tile tile = new Tile(false, "o");
        assert(tile.toString().equals("o"));
    }

    @Test(timeout =50)
    public void TestTileToString_2() {
        Tile tile = new Tile(false, "x");
        assert(tile.toString().equals("x"));
    }
    // TODO add test for checking whether at tile is traversable or not
}
