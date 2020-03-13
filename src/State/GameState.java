package State;

import game.Config;
import game.Game;
import game.image.Asset;
import player.Player;

import java.awt.*;

public class GameState extends State {
    private Player player;
    private int start;
    public GameState(Game game) {
        super(game);
        player = new Player(game);
        start = 0;
    }

    @Override
    public void tick() {
        if(start<300)
            start++;
        else
            player.tick();
    }

    @Override
    public void render(Graphics g) {

        if(start < 100){
            g.drawImage(Asset.background,0,0,Config.width,Config.height,null);
            g.drawImage(Asset.three,400,200,200,300,null);
        }
        if(start > 100 && start < 200){
            g.drawImage(Asset.background,0,0,Config.width,Config.height,null);
            g.drawImage(Asset.two,400,200,200,300,null);
        }
        if(start > 200 && start < 300){
            g.drawImage(Asset.background,0,0,Config.width,Config.height,null);
            g.drawImage(Asset.one,400,200,200,300,null);
        }
        if(start==300)
            g.drawImage(Asset.background,0,0,Config.width,Config.height,null);
            player.render(g);
    }

    public Player getPlayer() {
        return player;
    }
}
