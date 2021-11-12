package game;

import java.io.*;

public class Serialize {
    public static void serializeGame(Game game){
        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/game.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game);
            out.close();
            fileOut.close();
            System.out.print("Serialized data is saved in /tmp/game.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void serializePlayerState(Game game){
        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/playerState.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game.getPlayerState());
            out.close();
            fileOut.close();
            System.out.print("Serialized data is saved in /tmp/playerState.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void serializeBoard(Game game){
        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/board.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game.getBoard());
            out.close();
            fileOut.close();
            System.out.print("Serialized data is saved in /tmp/board.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void serializeObjectManager(Game game){
        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/objectManager.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game.getBoard().getObjectStateManager());
            out.close();
            fileOut.close();
            System.out.print("Serialized data is saved in /tmp/objectManager.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
