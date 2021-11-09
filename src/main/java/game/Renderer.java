package game;

import boards.Board;

public class Renderer {

    public String renderBoard(Board board) {
        int boardSize = board.getSize();
        StringBuilder boardRepr = new StringBuilder();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                int[] pos = {i, j};
                Object element = board.getElement(pos);
                String sprite = ".";
                if ( element != null) {
                    sprite = element.toString();
                }
                boardRepr.append(sprite);
            }
            boardRepr.append('\n');
        }

        boardRepr.setCharAt(0, 'P');
        boardRepr.setCharAt((boardSize + 1) * boardSize-2, 'G');

        return boardRepr.toString();

    }




    public String renderGame(Game game) {

        // the only difference is that game knows where player is.

        Board board = game.getBoard();
        Player player = game.getPlayer();
        int[] playerPos = player.getPos();
        int playerLinearPos = playerPos[0] * (board.getSize() + 1) + playerPos[1];

        String boardRepr = this.renderBoard(board);
        // TODO: this is a bad temporary fix for resetting the game.Player's starting position. Thre is an off chance that game.Player fails to move at first, so resetting the [0,0] to . is not reasonable. But in GUI, we'll deal with layering of images, so this rendering is OK for debugging purposes.
        String gameString= '.' + boardRepr.substring(1, playerLinearPos) + "P" + boardRepr.substring(playerLinearPos + 1);

        return gameString;
    }

}