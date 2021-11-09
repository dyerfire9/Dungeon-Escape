package game;

import boards.Board;
import elements.ChangePoints;


public class Game {

    private boolean isRunning;
    private Board board;
    private Player player;

    public Game (Board board) {
        this.board = board;
        this.isRunning = true;
        int[] pos = {0,0};
        this.player = new Player(pos, "P");
    }

    public void movePlayer(int[] move) {
        int[] currentPos = player.getPos();
        int[] newPos = {currentPos[0] + move[0], currentPos[1] + move[1]};
        Object element = board.getElement(newPos);
        // TODO: need to refine this logic...if newPos has a points-changer, can game.Player still move onto that position? In pacman, you "eat" a points-changer, and move onto its position.
        player.setPos(newPos);
        if (element == null)  {
        }
        else  {
            System.out.println("Met an element!");
        }
    }


    public void changePlayer(Object e) {
        if (e instanceof ChangePoints){
           player.changePoints(((ChangePoints) e).getChange());
        }
        System.out.println("Your now have " + player.getPoints() + " points.");
    }




    // Getter & Setter for game status.
    public boolean isRunning() {
        return this.isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getPlayer() {
        return this.player;
    }

}
