import boards.Board;
import elements.*;

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

    public Board createBoard(int size) {
        return new Board(size);
    }

    public String renderBoard(Board board) {
        Renderer renderer = new Renderer();
        return renderer.renderBoard(board);
    }

    public void seedBoard(Board board) {
        while (true) {
            System.out.println("\nWould you like to seed the board? Y/N.");
            if (reader.next().equalsIgnoreCase("Y")){
                reader.nextLine(); //consume the newline left-over
                System.out.println("\nWhat element do you want to place? Choose from 1, 2, 3, 4. ");
                // TODO: hook up 1, 2, 3, 4 to GUI element representations. No need to validate here.
                // Note that scanner.nextInt() does not read to the newline char.
                int type = reader.nextInt();
                reader.nextLine();

                System.out.println("\nGreat! Where do you want to place it? Type in a pair of integers like 2, 3. ");
                // Not going to validate input here as this will be done in GUI.
                String input = reader.nextLine();
                int x = Integer.parseInt(input.substring(0,1));
                int y = Integer.parseInt(input.substring(3, 4));

                System.out.println("x is " + x);
                System.out.println("y is " + y);
                int[] pos = {x, y};

                Element e;
                switch (type) {
/*
                    case 1:
                        e = new StationaryBlock("X", pos);
                        break;
*/
                    case 2:
                        e = new StationaryChangePoints("C", pos);
                        break;
                    case 3:
                        e = new MovableBlock("M", pos);
                        break;
                    case 4:
                        e = new MovableChangePoints("W", pos);
                        break;
                    default: // TODO: delete as it is mere placeholder
                        e = new StationaryBlock("X", pos);
                }

                board.setElement(pos, e);

                // Goal
                int[] goalPos = {board.getSize() - 1, board.getSize() - 1};
                Element goal = new Goal("G", goalPos);
                board.setElement(goalPos, goal);

                System.out.println(this.renderBoard(board));
            }

            else {
                // Goal
                int[] goalPos = {board.getSize() - 1, board.getSize() - 1};
                Element goal = new Goal("G", goalPos);
                board.setElement(goalPos, goal);

                System.out.println("\nNow you have a ready-to-play board! Game starts......");
                break;
            }
        }
    }

    public Board makeGame(){
        int boardSize = this.getBoardSize();
        Board board = this.createBoard(boardSize);
        this.seedBoard(board);
        return board;
    }

}

