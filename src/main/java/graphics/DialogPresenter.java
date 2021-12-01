package graphics;

import utils.EventEmitter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DialogPresenter extends EventEmitter {

    public static void present() throws IOException {
        // Instantiate dialogs, attach observers
        BoolDialog bd = new BoolDialog("User save state detected. Would you like" +
                " to load it?");
        TextDialog td = new TextDialog("Please enter the size of the board.");
        bd.attach((eventType, args) -> {
            if (eventType.equals("userClickedYes")) {
                System.out.println("User clicked 'Yes'");
                bd.hide();
            } else if (eventType.equals("userClickedNo")) {
                System.out.println("User clicked 'No'");
                bd.hide();
                td.show();
            }
        });
        td.attach((eventType, args) -> {
            try {
                if (eventType.equals("userSubmit")) {
                    String inputStr = (String) args[0];
                    int input = Integer.parseInt(inputStr);
                    System.out.printf("User input integer '%d'.", input);
                    td.hide();
                }
            } catch (NumberFormatException nfe) {
                td.setErrorMsg("Text is not a valid integer.");
            } catch (Exception e) {
                td.setErrorMsg("Unknown internal error.");
            }
        });

        // Decide which dialogs to show
        // Show the appropriate dialogs
        File file = new File("game.ser");
        boolean hasSavedGame = file.exists();

        if (hasSavedGame) {
            bd.show();
        } else {
            td.show();
        }

    }
}
