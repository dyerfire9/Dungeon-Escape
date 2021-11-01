/**
 * Contains the main game loop.
 */
public class Main {

    public static void main(String[] args) {

        GameMaker gameMaker = new GameMaker();
        GameRunner gameRunner = new GameRunner(gameMaker.makeGame());

        gameRunner.runGame();
    }
}