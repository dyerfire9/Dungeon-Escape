package game;

import boards.Board;
import elements.*;
import utils.Point2D;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.File;

public class GameMaker {
    private Scanner reader;

    public GameMaker() {
        this.reader = new Scanner(System.in);
    }

    public int[] getBoardSize() {
        System.out.println("\nIt's time to make your own game!");
        System.out.println("\nWhat is the size of your game board?");
        while (!reader.hasNextInt()) {
            System.out.println("\nPlease type in an integer.");
        }
        int boardSize = reader.nextInt();

        System.out.println("\nNice! Your board size is " + boardSize + ".");

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        File file = new File("game.ser");
        boolean condition = file.exists();

        if (condition) {
            System.out.println("\nSave state detected, do you want to load it or start from scratch?");
            while (!reader.hasNextBoolean()) {
                System.out.println("\nPlease type in a boolean");
            }
            boolean option = reader.nextBoolean();

            int[] values = new int[2];

            values[0] = boardSize;
            values[1] = option ? 1 : 0;
            return values;
        }
        else  {
            int[] values = new int[2];
            values[0] = boardSize;
            return values;
        }
    }


    public void seedBoard(Board board) {}

    /*
    public Board makeGame(){
        int boardSize = this.getBoardSize();
        Board board = new Board(boardSize);
        this.seedBoard(board);
        return board;
    }
*/
}

