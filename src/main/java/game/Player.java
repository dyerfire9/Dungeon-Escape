package game;

import javafx.scene.image.Image;
import utils.Point2D;

public class Player {
    private Point2D pos;
    private int points;
    private final Image sprite;

    public Player(Point2D pos){
        this.pos= pos;
        this.points = 100;
        this.sprite =  new Image("file:src/main/assets/player/deep_elf_blademaster.png");
    }


    public Point2D getPos(){
        return pos;
    }
    public void setPos(Point2D newPos) { this.pos = newPos; }


    public void setPoints(int p){
        points += p;
    }
    public int getPoints(){
        return points;
    }
    public void changePoints(int change) {this.points += change;}

    public Image getSprite() {
        return this.sprite;
    }
}
