package pipe;

import game.Config;
import game.Game;
import game.image.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Pipe {
    private int x;
    private double velocity;
    private int pipeLength;
    private BufferedImage pipeImage1;
    private BufferedImage pipeImage2;
    public Pipe(){
        Random random = new Random();
        x = Config.width;
        velocity = Config.pipeVelocity;
        pipeImage1 = Asset.pipe1;
        pipeImage2 = Asset.pipe2;
        pipeLength = random.nextInt(250)+70;
    }
    public void render(Graphics g){
        g.drawImage(pipeImage1,x,0,Config.pipeHeight,pipeLength,null);
        g.drawImage(pipeImage2,x,pipeLength+Config.space,Config.pipeHeight,Config.width-Config.space-pipeLength,null);
        //g.drawImage(pipeImage1,x,0,100,200,null);
        //g.drawImage(pipeImage2,x,pipeLength+Config.space,Config.pipeHeight,Config.width-Config.space-pipeLength,null);
    }
    public void tick(){
        x = x-(int)Config.pipeVelocity;
    }

    public int getX() {
        return x;
    }

    public int getPipeLength() {
        return pipeLength;
    }
}
