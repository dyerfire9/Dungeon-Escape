import java.util.*;

/**
 * Wrapper class for running an instance of Game
 */
public class GameRunner {

    public void runGame(Game game) {
        Scanner reader = new Scanner(System.in);
        SystemInOut inOut = new SystemInOut();
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
