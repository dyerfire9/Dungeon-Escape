/**
 * Parses input from the command line.
 * In the current version, it only responds to movement commands.
 */
public class SystemInOut {

    /**
     * Parses the user's command and returns a movement action.
     * @param input The user's command.
     * @return An int representing the desired movement direction.
     */
    public int parse(String input) {
        switch (input) {
            case "a":
                return -1;
            case "d":
                return 1;
            // In the consumer class, Integer.MIN_VALUE is taken to mean "quit the game".
            //TODO: Find a more organized solution
            case "quit":
                return Integer.MIN_VALUE;
            default:
                return 0;
        }
    }
}
