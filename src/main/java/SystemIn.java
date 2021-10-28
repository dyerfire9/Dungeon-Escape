/**
 * Parses input from the command line.
 * In the current version, it only responds to movement commands.
 */

public class SystemIn {

    /**
     * Parses the user's command and returns a movement action.
     * @param input The user's command.
     * @return An int representing the desired movement direction.
     */
    public int[] parse(String input) {
        // TODO When we scale, we'll need a Key-value mapping. Can't keep adding code to this.
        // TODO Either make a hashmap instance variable or a separate CommandLookup class with add and remove methods
        int[] move = {0, 0};// better way to represent?
        switch (input) {
            case "a":
                move[1] = -1;
                break;
            case "d":
                move[1] = 1;
                break;
            case "w":
                move[0] = -1;
                break;
            case "s":
                move[0] = 1;
                break;
            // In the consumer class, Integer.MIN_VALUE is taken to mean "quit the game".
            //TODO: Find a more organized solution
            case "quit":
                move[0] = Integer.MIN_VALUE;
                break;
            default:
                System.out.println("Invalid move");
        }
        return move;
    }
}
