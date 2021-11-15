package elements;

import game.Player;
import org.junit.Test;
import utils.PlayerState;
import utils.Point2D;

public class AlligatorTest {
        @Test(timeout = 500)
        public void TestAlligatorMovement() {
            Alligator alligator = new Alligator("alligator", new Point2D(6, 5),
                    20, 60, new Point2D(1, 0));

            for (int i = 0; i <= 60; i++) {
                alligator.processTick();
            }
            assert (Point2D.equals(alligator.getPos(), new Point2D(7, 5)));
        }
        @Test(timeout = 500)
        public void TestAlligatorNoMove() {
            Alligator alligator = new Alligator("alligator", new Point2D(6, 5),
                    20, 60, new Point2D(1, 0));

            for (int i = 0; i <= 59; i++) {
                alligator.processTick();
            }
            assert (!Point2D.equals(alligator.getPos(), new Point2D(7, 5)));
        }
        @Test(timeout = 500)
        public void TestAlligatorInteractionInvincible() {
            Alligator alligator = new Alligator("alligator", new Point2D(6, 5),
                    20, 60, new Point2D(1, 0));

            PlayerState playerState = new PlayerState(100);

            PlayerState modifiedPlayerstate =  alligator.changePlayerState(playerState);
            assert (modifiedPlayerstate.getPoints() == 100);
        }
        @Test(timeout = 500)
        public void TestAlligatorInteractionVunerable() {
            Alligator alligator = new Alligator("alligator", new Point2D(6, 5),
                    20, 60, new Point2D(1, 0));

            PlayerState playerState = new PlayerState(100);

            for (int i = 0; i <= 60; i ++) {
                playerState.decrementIframes();
            }

            PlayerState modifiedPlayerstate =  alligator.changePlayerState(playerState);
            assert (modifiedPlayerstate.getPoints() == 99);
        }
    }
