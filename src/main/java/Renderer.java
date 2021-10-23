import Boards.Board;
import Boards.MovableCoverBoard;
import Boards.StationaryCoverBoard;

import java.util.ArrayList;

public class Renderer {

    public String renderGame(Game game) {
        ArrayList<Board> boards_list = game.getBoards();
        Player player = game.getPlayer();

        // TODO: find better way to iterate through all boards
        Board board = boards_list.get(0);
        StationaryCoverBoard scb = (StationaryCoverBoard) boards_list.get(1);
        MovableCoverBoard mcb = (MovableCoverBoard) boards_list.get(2);


        int boardSize = board.getSize();


        StringBuilder boardRepr = new StringBuilder();
        for (int i = 0; i < (boardSize + 1) * boardSize; i++) {
            Object board_res = board.getElement(i);
            Object scb_res = scb.getElement(i);
            Object mcb_res = mcb.getElement(i);


            if ((i+1) % (boardSize + 1) == 0){ // break up 1D string to 2D matrix. Note that this algorithm have to change if use more than 1 char to represent elements.
                boardRepr.append('\n');
                continue;
            }
            if (board_res != null) {   // an edge block
                boardRepr.append(board_res.toString());
            } else { // not an edge block
                if (scb_res == null) { // nothing on stationary board
                    if (mcb_res == null) {// nothing on movable board
                        boardRepr.append("o");
                    }
                    else { // something on the movable board
                        boardRepr.append(mcb_res.toString());
                    }
                }
                else {  // something on the stationary board
                    boardRepr.append(scb_res.toString());
                }
            }
        }
        // change player's sprite:
        boardRepr.setCharAt(player.getPos(), 'P');

        return boardRepr.toString();
    }

}