package Boards;

import InteractiveElements.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class MovableCoverBoard extends Board {
    public MovableCoverBoard(int boardSize, int difficultyLevel) {
        super(boardSize);

        // TODO: better way to incorporate difficultyLevel in the algo.
        int numOfElements = (boardSize + 1) * boardSize / difficultyLevel;

        // TODO: extract randomizing algo
        for (int i = 0; i < numOfElements; i++) {
            Timer timer = new Timer();

            InteractiveElement mcp = IEFactory.getType("MovableChangePoints");
            timer.schedule(new TimerTask() {
                int randomPos = ThreadLocalRandom.current().nextInt(0, (boardSize + 1) * boardSize);
                int randomDelta = ThreadLocalRandom.current().nextInt(1, 3);

                @Override
                public void run() {
                    MovableCoverBoard ref = MovableCoverBoard.this;
                    int boardSize = ref.getSize();
                    int linearBoardSize = (boardSize + 1) * boardSize;

                    ref.setElement(randomPos, null);
                    // TODO: this is one simple way to randomize movements
                    randomPos  = (randomPos +  randomDelta ) % linearBoardSize;
                    ref.setElement(randomPos, mcp);
                }
            }, 0, ThreadLocalRandom.current().nextInt(1, 3) * 1000);
        }


        for (int i = 0; i < numOfElements / 3; i++) {
            Timer timer = new Timer();

            InteractiveElement mb = IEFactory.getType("MovableBlock");
            timer.schedule(new TimerTask() {
                int randomPos = ThreadLocalRandom.current().nextInt(0, (boardSize + 1) * boardSize);
                int randomDelta = ThreadLocalRandom.current().nextInt(1, 3);
                int randomDirectionSwitch = ThreadLocalRandom.current().nextInt(1, 4); //down, right, up, left

                @Override
                public void run() {
                    MovableCoverBoard ref = MovableCoverBoard.this;
                    int boardSize = ref.getSize();
                    int linearBoardSize = (boardSize + 1) * boardSize;

                    ref.setElement(randomPos, null);
                    // TODO: this is a more complex way to travel in all 4 directions by random distance
                    switch (randomDirectionSwitch) {
                        case 1: // down, wrap around
                            randomPos = (randomPos + randomDelta * (boardSize + 1)) % linearBoardSize;
                            break;
                        case 2: // right, wrap around
                            randomPos = (randomPos + randomDelta) % linearBoardSize;
                            break;
                        case 3: // up, wrap around
                            randomPos = ((randomPos - randomDelta * (boardSize + 1)) % linearBoardSize + linearBoardSize) % linearBoardSize;
                            break;
                        case 4: // left wrap around
                            randomPos = ((randomPos - randomDelta) % linearBoardSize + linearBoardSize) % linearBoardSize;
                    }
                    ref.setElement(randomPos, mb);
                }
            }, 0, ThreadLocalRandom.current().nextInt(1, 3) * 1000);
        }
    }
}
