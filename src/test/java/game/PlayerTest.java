package game;

import org.junit.*;
import utils.Point2D;
import utils.EnumsForSprites;

public class PlayerTest {
    @Test(timeout = 500)
    public void TestPlayerBasics(){
        Point2D a = new Point2D(4,4);
        Player player = new Player(a);

        assert(player.getPos() == a);
        Point2D b = new Point2D(3,2);
        player.setPos(b);
        assert (player.getPos() == (b));

        assert (player.getPlayerState().getPoints() == (100));
        PlayerState c = new PlayerState(20, new Point2D(2,2));
        player.setPlayerState(c);
        assert (player.getPlayerState().getPoints() == (20));
        assert player.getSprite() == EnumsForSprites.PLAYER;
        assert player.checkWon() == false;
        assert player.checkLoss() == false;
        player.decrementIframes();
        assert player.getPlayerState().getiFrames() == 59;
        player.resetPlayerState();
        assert player.getPlayerState().getiFrames() == 60;
    }


}
