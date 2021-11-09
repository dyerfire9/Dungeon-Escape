import java.io.*;

public class Serialize {
    public static void Serialize(Game game){
        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/game.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/game.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
