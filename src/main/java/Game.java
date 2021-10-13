/**
 * Controls the system responsible for receiving player inputs and updating Board.
 */


public class Game {
    private Board board; // 1D array for now
    private Player player; //assuming 1 player for now.


    public void setup(){
        // initilize a Seeder, a Board
    }


    public void end() {
        //

    }

    public int[] moveProcessor(String input) {

        //deals with invalid inputs
        //converts valid inputs into int[1,0] etc.
        return null;
    }


    /**
     * Prints the current board state.
     * @return A string showing each tile of the board.
     */
    @Override
    public String toString() {  //TODO: Shouldn't this belong to Board?
            return this.board.toString();
        }
    }
