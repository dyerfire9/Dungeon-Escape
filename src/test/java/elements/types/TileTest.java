package elements.types;

import org.junit.Test;
import utils.EnumsForSprites;

public class TileTest {
    @Test(timeout = 500)
    public void TestTileFalse(){
        Tile tile = new Tile(false);
        assert tile.isTraversable() == false;
        assert tile.getSprite() == EnumsForSprites.NOT_TRAVERSABLE;
    }

    @Test(timeout = 500)
    public void TestTileTrue(){
        Tile tile = new Tile(true);
        assert tile.isTraversable() == true;
        assert tile.getSprite() == EnumsForSprites.IS_TRAVERSABLE;
    }

}