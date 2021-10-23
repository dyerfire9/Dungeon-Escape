package Boards;

import InteractiveElements.IEFactory;

import java.util.concurrent.ThreadLocalRandom;

public class StationaryCoverBoard extends Board {
    public StationaryCoverBoard(int boardSize, int difficultyLevel) {
        super(boardSize);
        // TODO: better way to incorporate difficultyLevel in the algo.
        // Update: pre algo: (n(n+1))/difficulty, new algo: (n-2)^2 * 0.01 * difficulty.
        // difficulty % of traversable area will be occupied by obstacle.
        int numOfElements = (boardSize - 2) * (boardSize - 2) * difficultyLevel / 100;
        for (int i = 0; i < numOfElements; i ++) {
            int randomInt = ThreadLocalRandom.current().nextInt(0, (boardSize + 1) * boardSize);
            this.setElement(randomInt, IEFactory.getType("StationaryChangePoints"));
            // TODO: refine randomizing algo for placing StationryBlocks
            this.setElement(randomInt / 3, IEFactory.getType("StationaryBlock"));
        }
    }
}
