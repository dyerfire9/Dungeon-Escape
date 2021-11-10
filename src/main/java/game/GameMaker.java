package game;

import boards.Board;
import elements.*;
import utils.Point2D;

import java.util.Scanner;

public class GameMaker {
    private Scanner reader;

    public GameMaker() {
        this.reader = new Scanner(System.in);
    }

    public int getBoardSize() {
        System.out.println("\nIt's time to make your own game!");
        System.out.println("\nWhat is the size of your game board?");
        while (!reader.hasNextInt()) {
            System.out.println("\nPlease type in an integer.");
        }
        int boardSize = reader.nextInt();

        System.out.println("\nNice! Your board size is " + boardSize + ".");
        return boardSize;
    }


    public void seedBoard(Board board) {}

    public Board makeGame(){
        int boardSize = this.getBoardSize();
        Board board = new Board(boardSize);
        this.seedBoard(board);
        return board;
    }

}

