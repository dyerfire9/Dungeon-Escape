package game;

import javafx.scene.image.Image;
import utils.PlayerState;
import utils.Point2D;

public class Player {
    private Point2D pos;
    public PlayerState playerState;
    private final Image sprite;

    public Player(Point2D pos){
        this.pos= pos;
        this.playerState = new PlayerState(100);
        this.sprite =  new Image("file:src/main/assets/player/deep_elf_blademaster.png");
    }


    public Point2D getPos(){
        return pos;
    }
    public void setPos(Point2D newPos) { this.pos = newPos; }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }
    public Image getSprite() {
        return this.sprite;
    }
    public void decrementIframes() {
        this.playerState.decrementIframes();
    }
    public PlayerState getPlayerState() {return this.playerState;}

}
