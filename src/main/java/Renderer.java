public class Renderer {

    public Renderer() {}

    public String renderGame(Game game) {
        String boardString = game.getBoardString();
        String playerString = game.getPlayerString();
        int playerPos = game.getPlayerPosition();

        return boardString.substring(0, playerPos)
                + playerString
                + boardString.substring(playerPos + 1);
    }
}
