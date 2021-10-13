import java.util.*;

/**
 * Contains the main game loop.
 */
public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Scanner reader = new Scanner(System.in);
        SystemInOut inOut = new SystemInOut();

        // Will halt the game loop if set to false.
        // TODO: Move isRunning to an instance of Game
        boolean isRunning = true;


        while (isRunning) {
            String input = reader.nextLine();
            int movement = inOut.parse(input);
            if (movement == Integer.MIN_VALUE) {
                System.out.println("Exiting program...");
                isRunning = false;
            } else {
                game.makeMove(movement);
                System.out.println(game);
            }
        }

    }
}