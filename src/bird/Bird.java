package bird;

import game.Config;
import game.Game;
import game.image.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird {
    private Game game;
    private int x,y;
    private double birdVelocity;
    private BufferedImage birdImage;
    private boolean live;
    public Bird(Game game){
        this.game = game;
        x = Config.birdX;
        y = Config.birdY;
        birdVelocity = Config.birdVelocity;
        birdImage = Asset.bird1;
        live = true;
    }
    public void fall(){
        y = y + (int)(birdVelocity);
    }
    public void fly(){
        y = y - (int)8   ;
    }
    public void die(){}
    public void render(Graphics g){
        g.drawImage(birdImage,x,y,80,80,null);
    }
    public void tick(){
        fall();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
