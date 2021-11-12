package game;

import org.junit.*;

public class DeserializeTest {
    @Test(timeout=50)
    public void TestDeserializeGame() {
        Game game = new Game(9);
        Serialize.serializeGame(game);
        assert Deserialize.deserializeGame().equals(game);
    }

    @Test(timeout=50)
    public void TestDeserializePlayerState() {
        Game game = new Game(9);
        Serialize.serializePlayerState(game);
        assert Deserialize.deserializePlayerState().equals(game.getPlayerState());
    }

    @Test(timeout=50)
    public void TestDeserializeBoard() {
        Game game = new Game(9);
        Serialize.serializeBoard(game);
        assert Deserialize.deserializeBoard().equals(game.getBoard());
    }

    @Test(timeout=50)
    public void TestDeserializeObjectManager() {
        Game game = new Game(9);
        Serialize.serializeObjectManager(game);
        assert Deserialize.deserializeObjectManager().equals(game.getBoard().getObjectStateManager());
    }

}