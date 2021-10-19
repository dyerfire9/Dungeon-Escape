public class Renderer {

    public Renderer() {}

    public String renderGame(Game game) {
        String boardString = game.getBoardString();
        String playerString = game.getPlayerString();
        int[] playerPos = game.getPlayerPosition();

        int playerLinearPos = playerPos[0]* (game.getBoardSize()+1) + playerPos[1] + 1;

        return boardString.substring(0, playerLinearPos)
                + playerString
                + boardString.substring(playerLinearPos+ 1);

    }
}
