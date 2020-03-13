package KeyManager;

import game.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPress implements KeyListener {
    private Game game;

    private boolean press = false;
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        press = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        press = false;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
    public boolean getPress(){
        return press;
    }
}
