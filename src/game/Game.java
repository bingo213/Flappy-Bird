package game;

import KeyManager.KeyPress;
import State.State;
import State.MenuState;
import State.GameState;
import State.EndGame;
import game.image.Asset;
import jaco.mp3.player.MP3Player;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;

public class Game implements Runnable{
    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private boolean lose;

    public State menuState;
    public GameState gameState;
    public State endGame;

    private KeyPress keyPress ;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyPress = new KeyPress();
    }

    private void init(){
        lose = false;
        display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyPress);
        display.getCanvas().addKeyListener(keyPress);
        Asset.init();
        gameState = new GameState(this);
        menuState = new MenuState(this);
        endGame = new EndGame(this);
        keyPress.setGame(this);
        State.setState(gameState);
    }
    private void tick(){
        if(State.getState() != null)
            State.getState().tick();
    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!
        if (State.getState() != null)
            State.getState().render(g);

        //End Drawing!
        bs.show();
        g.dispose();
    }
    @Override
    public void run(){

        init();
        Config.mp3player = new MP3Player(Config.start);
        Config.mp3player.play();


        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public KeyPress getKeyPress() {
        return keyPress;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public boolean isLose() {
        return lose;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}

