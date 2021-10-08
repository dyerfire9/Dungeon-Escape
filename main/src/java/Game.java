package java;
import java.constants.*;
/**
 * Controls the system responsible for receiving player inputs and updating Board.
 */


public class Game {
    private Seeder seeder; // use seeder to control difficulty level.
    private Board gameBoard;
    private Player player; //assuming 1 player for now.



    public void run(Inout inOut) {

        inOut.sendOutput(Constants.initGamePrompt);
        String init = inOut.getInput();
        if (init == "start") {

            this.setup(); // get difficulty level and dimension from User. Create a properly seeded gameBoard. Create a Player.

            inOut.sendOutput(Constants.movePrompt);
            try {
                String input = inOut.getInput();
                while (!input.equals("quit")) {
                    inOut.sendOutput(Constants.movePrompt);
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
            inOut.sendOutput(Constants.invalidInputPrompt);
            this.run(inOut);
        }

    }

    public void setup(){
        //
    }


    public void end() {
        //

    }

    public int[] moveProcessor(String input) {

        //deals with invalid inputs
        //converts valid inputs into int[1,0] etc.
    }

    private ?  boardResProcessor(String response){
        //if "out of boundary"...
        //if normal spot
        //if blocked
        // if gain points
        // if lose points
        int newPoints = player.pointsGetter();
        if (newPoints < 0) {
            this.end();
        }
    }

}