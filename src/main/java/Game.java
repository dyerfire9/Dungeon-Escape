/**
 * Controls the system responsible for receiving player inputs and updating Board.
 */


public class Game {
    private Board board;
    private Player player; //assuming 1 player for now.
    private boolean isRunning = true;

    public Game() {
        //Todo: seed board with objects. Player must start at a traversable position.
        this.board = new Board(10);
        int[] startingPos = {5,5};
        this.player = new Player(startingPos, "P");
    }

    public void makeMove(int[] move) {
        this.player.makeMove(move, this.board);
    }

    // Getter & Setter for game status.
    public boolean getRunning(){return this.isRunning; }
    public void setRunning(boolean isRunning) {this.isRunning = isRunning; }

    public int[] getPlayerPosition() {return this.player.getPos();}
    public int getBoardSize() {return board.getSize();}
    public String getPlayerString() {return this.player.toString();}
    public String getBoardString() {return this.board.toString();}
    }
