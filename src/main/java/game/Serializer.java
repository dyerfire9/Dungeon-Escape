package game;

import java.io.*;

public class Serializer {

    /**
     * A serializer to save game data to a .ser file and report when completed.
     */
    public static void serialize(Game game){
        try {
            FileOutputStream fileOut = new FileOutputStream("game.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game);
            out.close();
            fileOut.close();
            System.out.print("Saved game is saved in game.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * A deserializer, which reads the saved game data in the .ser file and converts the saved game data back into a game.
     */
    public static Game deserialize(){
        Game game = null;
        try {
            FileInputStream fileIn = new FileInputStream("game.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            game = (Game) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("game.Game class not found");
            c.printStackTrace();
        }
        return game;
    }
}
