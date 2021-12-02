package graphics;

import javafx.beans.InvalidationListener;
import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DialogPresenter {

    private boolean done;
    private int requestedBoardSize;
    private BoolDialog bd;
    private TextDialog td;
    private ArrayList<InvalidationListener> listeners = new ArrayList<>();

    public DialogPresenter() throws IOException {
        done = false;
        bd = new BoolDialog("User save state detected. Would you like" +
                " to load it?");
        td = new TextDialog("Please enter the size of the board.");
        bd.addOnClickedYes(event -> {
            System.out.println("User clicked 'Yes'");
            bd.hide();
        });
        bd.addOnClickedNo(event -> {
            System.out.println("User clicked 'No'");
            bd.hide();
            td.show();
        });
        td.addOnKeyPressed(this::onUserSubmit);
        td.addOnClickedButton(this::onUserSubmit);
    }

    public void present() {
        File file = new File("game.ser");
        if (file.exists()) {
            bd.show();
        } else {
            td.show();
        }
    }

    private void onUserSubmit(Event event) {
        try {
            // Suppress response if user typed in non-ENTER key
            if (event instanceof KeyEvent) {
                KeyEvent keyEvent = (KeyEvent) event;
                if (keyEvent.getCode() != KeyCode.ENTER) {
                    return;
                }
            }
            requestedBoardSize = Integer.parseInt(td.getText());
            td.clearErrorMsg();
            td.hide();
            System.out.printf("User entered integer '%d'.\n", requestedBoardSize);
        } catch (NumberFormatException nfe) {
            td.setErrorMsg("Input is not a valid integer.");
            System.out.printf("User entered non-integer '%s'.\n", td.getText());
        } catch (Exception e) {
            td.setErrorMsg("An unknown error occurred.");
        }
    }
}
