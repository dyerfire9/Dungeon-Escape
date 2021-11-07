import game.Player;
import org.junit.*;

public class PlayerTest {
    @Test(timeout = 50)
    public void TestPlayerBasics(){
        Player player = new Player(25, "P");

        assert(player.getPos() == (25));
        player.setPos(27);
        assert (player.getPos() == (27));

        assert (player.getPoints() == (100));
        player.setPoints(20);
        assert (player.getPoints() == (120));

        player.changePoints(10);
        assert (player.getPoints() == 130);

    }

    @Test(timeout = 50)
    public void TestPlayerToString(){
        Player player = new Player(25, "P");
        assert (player.toString().equals("P"));
    }

}
