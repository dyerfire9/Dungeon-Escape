import java.util.*;

/**
 * Contains the main game loop.
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner reader = new Scanner(System.in);
        SystemInOut inOut = new SystemInOut();

        System.out.println("Welcome to the game!");
        System.out.println("Show me a move: 'a' for moving one step left; 'd' for moving one step right. ");
        System.out.println("To quit the game, type in 'quit'.\n");
        System.out.println(game);

        // Will halt the game loop if set to false.
        boolean isRunning = game.getRunning();


        while (isRunning) {
            if (game.getPlayer().getPoints() < 0){
                System.out.println("You've lost all points :(. \n End of game.");
                game.setRunning(false);
            }
            else {
                System.out.println("\nWhat is your move?");
                String input = reader.nextLine();
                int movement = inOut.parse(input);
                if (movement == Integer.MIN_VALUE) {
                    System.out.println("Exiting program...");
                    game.setRunning(false);
                } else {
                    game.makeMove(movement);
                    // System.out.println("Nice move!"); Not using this right now due to lack of distinction between hitting an obstacle and hitting the board boundary.
                    System.out.println(game);
                }
            }
            isRunning = game.getRunning();
        }
    }
}