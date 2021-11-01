import boards.Board;

import java.util.*;

public class GameRunner {
    private Board board;
    private Game game;
    private Player player;
    private Renderer renderer;
    private SystemIn parser;

    public GameRunner(Board board) {
        this.board = board;
        this.game = new Game(this.board);
        this.player = this.game.getPlayer();

        this.parser = new SystemIn();
        this.renderer = new Renderer();
    }


    // runGame takes in a move, parse it -> (game.movePlayer, game.changePlayer, RenderGame)
    public void runGame() {
        System.out.println("Your now have " + player.getPoints() + " points.");
        Scanner reader = new Scanner(System.in);
        while (this.game.isRunning()) {
            System.out.println("\nWhat is your move?");
            String input = reader.nextLine().toLowerCase();
            int[] move = this.parser.parse(input);
            if (move[0] == Integer.MIN_VALUE) {
                System.out.println("\nExiting program...");
                this.game.setRunning(false);
            }
            else {
                this.game.movePlayer(move);
                this.game.changePlayer(board.getElement(this.player.getPos())); // TODO: This may change slightly depending on what we decide with points-changers. Right now Player occupies the element's position and "shadows" its sprite.
                System.out.println(this.renderer.renderGame(this.game));

                if (this.player.getPoints() < 0) {
                    this.game.setRunning(false);
                    System.out.println("\nYou lost all points...Game ends.");
                }
            }
        }
    }

}
