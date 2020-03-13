package State;

import game.Game;
import game.image.Asset;

import java.awt.*;

public class EndGame extends State {

    public EndGame(Game game) {
        super(game);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.gameover, 200, 200,500,300,null);
    }
}
