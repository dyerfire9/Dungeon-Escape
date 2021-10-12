package java;

/**
 * Controls the system responsible for receiving player inputs and updating Board.
 */


public class Game {
    private Seeder seeder; // use seeder to control difficulty level.
    private Board gameBoard; // 1D array for now
    private Player player; //assuming 1 player for now.



    public void run(Inout inOut) {

        inOut.sendOutput(initGamePrompt);
        String init = inOut.getInput();
        if (init == "start") {

            this.setup(); // get difficulty level and dimension from User. Create a properly seeded gameBoard. Create a Player.

            inOut.sendOutput(movePrompt);
            try {
                String input = inOut.getInput();
                while (!input.equals("quit")) {
                    inOut.sendOutput(movePrompt);
                    input = inOut.getInput();
                    if (!input.equals("quit")) {
                        int[] move = this.moveProcessor(input);
                        player.makeMove(move);
                        int[] newPos = player.getPos();
                        // send new position to Board
                        String res = gameBoard.check(newPos);
                        inOut.sendOutput(res);
                        // game processes the response from board.
                        this.boardResProcessor(res);
                    }
                }
            } catch {
                ///
            }
        } else if (init == "quit") {
            this.end();
        } else {
            inOut.sendOutput(invalidInputPrompt);
            this.run(inOut);
        }

    }

    public void setup(){
        // initilize a Seeder, a Board
    }


    public void end() {
        //

    }

    public int[] moveProcessor(String input) {

        //deals with invalid inputs
        //converts valid inputs into int[1,0] etc.
    }

//    private ?  boardResProcessor(String response){
//        //if "out of boundary"...
//        //if normal spot
//        //if blocked
//        // if gain points
//        // if lose points
//        int newPoints = player.pointsGetter();
//        if (newPoints < 0) {
//            this.end();
//        }
//    }

    /**
     * Prints the current board state.
     * @return A string showing each tile of the board.
     */
    @Override
    public String toString() {  //TODO: Shouldn't this belong to Board?
        int[] bo = gameBoard.getBoard();
        for (int i = 0; i < gameBoard.getSize(); i++) {
            System.out.print(bo[i] + " ");
        }
    }
}