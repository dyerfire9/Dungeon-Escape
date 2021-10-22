/**
 * Contains the main game loop.
 */
public class Main {

    public static void main(String[] args) {

        GameRunner gameRunner = new GameRunner();

        System.out.println("Welcome to the game!");
        System.out.println("Show me a move: 'a' for moving one step left; 'd' for moving one step right. ");
        System.out.println("To quit the game, type in 'quit'.\n");

        gameRunner.runGame();
    }
}