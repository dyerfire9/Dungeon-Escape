/**
 * Controls the system responsible for receiving player inputs and updating Board.
 */


public class Game {
    private Board board; // 1D array for now
    private Player player; //assuming 1 player for now.
    private Renderer renderer;

    public Game() {
        this.board = new Board(10);
        this.player = new Player(5, "X");
        this.renderer = new Renderer();
    }

    public void makeMove(int move) {
        this.player.makeMove(move, this.board);
    }

    public String renderGame() {
        return renderer.renderGame(this.player, this.board);
    }
}
