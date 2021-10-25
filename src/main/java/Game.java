import Boards.Board;
import Boards.MovableCoverBoard;
import Boards.StationaryCoverBoard;
import InteractiveElements.MovableChangePoints;
import InteractiveElements.StationaryChangePoints;

import java.util.ArrayList;


public class Game {

    private boolean isRunning;
    private ArrayList<Board> boards_list;
    private Player player;

    // TODO: Set up a trigger pattern for adding new boards.
    Board board = new Board(20);
    StationaryCoverBoard scb = new StationaryCoverBoard(20, 20);
    MovableCoverBoard mcb = new MovableCoverBoard(20, 20);

    public Game () {
        // TODO: game can take in some params for more custom features.
        this.isRunning = true;

        // TODO: Consider: the coverBoards need not be the exact same size as the base board.
        // TODO: Use an iterator to go thru the boards_list.
        this.boards_list = new ArrayList<>();
        this.boards_list.add(board);
        this.boards_list.add(scb);
        this.boards_list.add(mcb);

        // TODO: find better way to initialize Player's starting position. Player cannot start at a blocked position.
        int startingPos = 88;
        this.player = new Player(startingPos, "P");

    }

    public void makeMove(int[] move) {
        int size = board.getSize();
        int delta_i = move[0];
        int delta_j = move[1];
        int newPos = this.player.getPos() + delta_i * (size + 1) + delta_j;

        Object board_res = board.getElement(newPos);
        Object stationary_res = scb.getElement(newPos);
        Object mcb_res = mcb.getElement(newPos);


        // TODO: the following is an example of three layers: 1. a bounded base board, 2. a cover board that holds stationary elements: either blocks or elements that can change player's points. 3. a cover board that holds movable elements: either blocks or point-changers.
        // TODO: better way to do the nested ifs?
        if (board_res == null) {
            if (stationary_res == null) {
                if (mcb_res == null) {
                    this.player.setPos(newPos);
                } else { // MovableCoverBoard is sending a MovableIE
                    if (mcb_res.toString().equals("W")) {
                        int change = ((MovableChangePoints) mcb_res).getChange();
                        this.player.changePoints(change);
                        System.out.println("Met a movable points changer - Points changed!");
                        System.out.println("Your points is " + this.player.getPoints());
                        this.player.setPos(newPos); // TODO: is it correct that player can move here?
                    } else {
                        System.out.println("There is a movable blocker - Cannot move there!");
                    }
                }
            } else { // StationaryCoverBoard is sending a StationaryIE
                if (stationary_res.toString().equals("C")) {
                    int change = ((StationaryChangePoints) stationary_res).getChange();
                    this.player.changePoints(change);
                    System.out.println("Met a stationary points changer - Points changed!");
                    System.out.println("Your points is " + this.player.getPoints());
                    this.player.setPos(newPos); // TODO: is it correct that player can move here?
                    // TODO: need better points system.

                }
                else {
                    System.out.println("There is a stationary blocker - Cannot move there!");
                }
            }
        }
        else { // base Board is sending a Wall element
            System.out.println("There is a wall - Cannot move there!");
        }
    }


    // Getter & Setter for game status.
    public boolean getRunning() {
        return this.isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }


    // TODO: need to write a method that returns all boards in this game.
    public ArrayList<Board> getBoards() {
        return this.boards_list;
    }

    public Player getPlayer() {
        return this.player;
    }

}
