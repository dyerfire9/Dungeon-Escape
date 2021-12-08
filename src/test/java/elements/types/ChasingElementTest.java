package elements.types;
import game.Board;
import game.ObjectManager;
import game.Player;
import org.junit.Test;
import game.PlayerState;
import utils.Point2D;
import utils.EnumsForSprites;

public class ChasingElementTest {

    @Test(timeout = 500)
    public void TestChasingElementIsPlaced() {
        Board board = new Board(20);
        ObjectManager objman = new ObjectManager(board.getSize() - 1);
        ChasingElement chaser = new ChasingElement(EnumsForSprites.CHASER, new Point2D(10, 10),
                15, 3, new Point2D(1, 1), true);
        board.fillBoard();
        board.fillEdges();
        objman.addObject(chaser);

        for(Element boardObject : objman.getBoardObjects()) {
            if (boardObject instanceof ChasingElement) {
                assert (boardObject.getPos() == chaser.getPos());
            } else {
                assert (boardObject.getPos() != chaser.getPos());
            }
        }
    }

    @Test(timeout = 500)
    public void TestChasingElementMoves() {
        Board board = new Board(20);
        ObjectManager objman = new ObjectManager(board.getSize() - 1);
        Point2D chaserPos = new Point2D(15,15);
        board.fillBoard();
        board.fillEdges();
        objman.addChasingElement(new Point2D(15, 15),3);

        ChasingElement chaser;
        for(Element boardObject : objman.getBoardObjects()) {
            if (boardObject instanceof ChasingElement) {
                chaser = (ChasingElement)boardObject;
                assert(chaser.getPos() != chaserPos);
            }
        }

        }

    @Test(timeout = 500)
    public void TestChasingElementModifyPlayerState() {
        Player player = new Player(new Point2D(5, 5));
        PlayerState ps = player.getPlayerState();
        Board board = new Board(20);
        ObjectManager objman = new ObjectManager(board.getSize() - 1);
        ChasingElement chaser = new ChasingElement(EnumsForSprites.CHASER, new Point2D(10, 10),
                15, 3, new Point2D(1, 1), true);
        board.fillBoard();
        board.fillEdges();
        objman.addObject(chaser);

        if (Point2D.equals(ps.getPos(), chaser.getPos())) {
            while (ps.getPoints() != 10) {
                chaser.Modify(ps);
            }
            assert(ps.getPoints() == 10);
        }
    }

    }
