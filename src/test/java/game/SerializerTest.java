package game;

import org.junit.Test;
import utils.Point2D;

public class SerializerTest {
    @Test(timeout=500)
    public void TestSerialization(){
        Game game = new Game(9);
        Point2D p = new Point2D(1,2);
        game.movePlayer(p);
        Serializer.serialize(game);
        Game n = Serializer.deserialize();
        assert n.getPlayerPosition().getX() == 6;
        assert n.getPlayerPosition().getY() == 7;

    }

}