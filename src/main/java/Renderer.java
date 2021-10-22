import Boards.Board;
import Boards.StationaryCoverBoard;

import java.util.ArrayList;

public class Renderer {

    public String renderGame(Game game) {
        ArrayList<Board> boards_list = game.getBoards();
        Player player = game.getPlayer();

        // TODO: find better way to iterate through all boards
        Board board = boards_list.get(0);
        StationaryCoverBoard scb = (StationaryCoverBoard) boards_list.get(1);


        int boardSize = board.getSize();


        StringBuilder boardRepr = new StringBuilder();
        for (int i = 0; i < (boardSize + 1) * boardSize; i++) {
            if ((i+1) % (boardSize + 1) == 0){ // break up 1D string to 2D matrix. Note that this algorithm have to change if use more than 1 char to represent elements.
                boardRepr.append('\n');
                continue;
            }
            if (board.getElement(i) != null) {   // an edge block
                boardRepr.append(board.getElement(i).toString());
            } else { // not an edge block
                if (scb.getElement(i) == null) {// nothing there
                    boardRepr.append("o");
                }
                else {  // has a stationary element
                    boardRepr.append(scb.getElement(i).toString());
                }
            }
        }
        // change player's sprite:
        boardRepr.setCharAt(player.getPos(), 'P');

        return boardRepr.toString();
    }

}