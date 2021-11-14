package game;

import org.junit.Test;
import utils.Point2D;

public class SerializeTest {
    @Test(timeout=50)
    public void TestSerialization(){
        Game game = new Game(9);
        Point2D p = new Point2D(1,2);
        game.movePlayer(p);
        Serialize.serialize(game);
        Game n = Serialize.deserialize();
        assert n.getPlayerPosition().getX() == 6;
        assert n.getPlayerPosition().getY() == 7;

    }

}