package game;

import java.io.*;

public class Deserialize {
    public static Game Deserialize(String [] args){
        Game game = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/game.ser");
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
