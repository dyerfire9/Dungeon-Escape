package game;

import boards.Board;
import boards.ObjectManager;
import utils.PlayerState;

import java.io.*;

public class Deserialize {
    public static Game deserializeGame(){
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

    public static PlayerState deserializePlayerState(){
        PlayerState playerState = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/playerState.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            playerState = (PlayerState) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("playerState.PlayerState class not found");
            c.printStackTrace();
        }
        return playerState;
    }

    public static Board deserializeBoard(){
        Board board = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/board.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            board = (Board) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("board.Board class not found");
            c.printStackTrace();
        }
        return board;
    }

    public static ObjectManager deserializeObjectManager(){
        ObjectManager objectManager = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/objectManager.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            objectManager = (ObjectManager) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("objectManager.ObjectManager class not found");
            c.printStackTrace();
        }
        return objectManager;
    }
}
