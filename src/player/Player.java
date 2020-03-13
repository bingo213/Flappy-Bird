package player;

import KeyManager.KeyPress;
import bird.Bird;
import game.Config;
import game.Game;
import game.image.Asset;
import pipe.Pipe;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Game game;
    private Bird bird;
    private List<Pipe> pipeList;
    private int score;
    private int count;
    public Player(Game game){
        this.game = game;
        bird = new Bird(game);
        pipeList = new ArrayList<>();
        score = 0;
        count = 149;
    }
    public void tick(){
        if(game.isLose()==false) {
            count++;
            if (count == 150) {
                Pipe p = new Pipe();
                pipeList.add(p);
                count = 0;
            }
            bird.tick();
            for (Pipe pipe : pipeList)
                pipe.tick();
            for (int i = 0; i < pipeList.size(); i++) {
                if (pipeList.get(i).getX() + Config.pipeHeight <= 0)
                    pipeList.remove(i);
                int l = pipeList.get(i).getPipeLength();
                if (pipeList.get(i).getX() <= Config.birdX + 80 - 10 && pipeList.get(i).getX() + Config.pipeHeight >= Config.birdX
                        && (bird.getY() < l || bird.getY() + 80 - 10 - 5 > l + Config.space))
                    game.setLose(true);
                if (pipeList.get(i).getX() == Config.birdX)
                {
                    score += 5;
                }
            }
            if (game.getKeyPress().getPress())
                bird.fly();
        }
    }
    public void render(Graphics g){
        bird.render(g);
        for(Pipe pipe : pipeList)
            pipe.render(g);
        g.drawImage(Asset.star,1000,10,50,50,null);
        if(game.isLose()==true)
            g.drawImage(Asset.gameover,250,200,650,300,null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.ROMAN_BASELINE,50));
        g.drawString(Integer.toString(score),1070,50);
    }
    public Bird getBird() {
        return bird;
    }

    public int getCount() {
        return count;
    }
}
