package game;

import game.PlayerState;
import org.junit.*;
import utils.Point2D;

import static org.junit.Assert.assertEquals;

public class PlayerStateTest {

    PlayerState ps = new PlayerState(40, new Point2D(2,2));

   @Test(timeout = 50)
   public void TestPlayerState() {
       assertEquals ("Points not constructed properly", ps.getPoints(), 40);
       assertEquals("hasWont not constructed properly", ps.getWinningState(), false);
       assertEquals("iFrames not constructed properly", ps.getiFrames(), 60);
   }

    @Test(timeout = 50)
    public void updatePoints() {
       ps.updatePoints(-5);
       assertEquals(ps.getPoints(), 35);
    }

    @Test
    public void decrementIframes() {
       for (int i = 0; i < 10; i ++) {
           ps.decrementIframes();
       }
       assertEquals(ps.getiFrames(), 50);

    }

    @Test
    public void checkInvincible() {
       assertEquals(ps.checkInvincible(), true);
    }



    @Test
    public void resetIframes() {
       assertEquals(ps.getiFrames(), 60);
    }



    @Test
    public void setWinningState() {
       ps.setWinningState(true);
       assertEquals(ps.hasWon, true);
    }

}