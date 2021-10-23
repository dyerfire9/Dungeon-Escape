package Boards;

import InteractiveElements.IEFactory;

import java.util.concurrent.ThreadLocalRandom;

public class StationaryCoverBoard extends Board {
    public StationaryCoverBoard(int boardSize, int difficultyLevel) {
        super(boardSize);
        // TODO: better way to incorporate difficultyLevel in the algo.
        int numOfElements = (boardSize + 1) * boardSize / difficultyLevel;
        for (int i = 0; i < numOfElements; i ++) {
            int randomInt = ThreadLocalRandom.current().nextInt(0, (boardSize + 1) * boardSize);
            this.setElement(randomInt, IEFactory.getType("StationaryChangePoints"));
            // TODO: refine randomizing algo for placing StationryBlocks
            // TODO: extract all randomizing patterns and create an interface?
            this.setElement(randomInt / 3, IEFactory.getType("StationaryBlock"));
        }
    }
}
