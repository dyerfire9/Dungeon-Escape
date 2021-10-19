import java.util.*;

/**
 * Wrapper class for running an instance of Game
 */
public class GameRunner {
    private Game game;
    private Renderer renderer;
    private SystemInOut parser;

    public GameRunner() {
        this.parser = new SystemInOut();
        this.game = new Game();
        this.renderer = new Renderer();
    }

    public void runGame() {
        Scanner reader = new Scanner(System.in);

        while (this.game.getRunning()) {
            System.out.println("\nWhat is your move?");
            String input = reader.nextLine();
            int[] movement = this.parser.parse(input);
            if (movement[0] == Integer.MIN_VALUE) {
                System.out.println("Exiting program...");
                this.game.setRunning(false);
            } else {
                this.game.makeMove(movement);
                //System.out.println("Nice move!"); Not using this right now due to lack of distinction between hitting an obstacle and hitting the board boundary.
                System.out.println(this.renderer.renderGame(this.game));
            }
        }
    }

}
