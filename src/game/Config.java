package game;

import jaco.mp3.player.MP3Player;

import java.io.File;

public class Config {
    public static final int width = 1200;
    public static final int height = 700;
    public static final double pipeVelocity = 3;
    public static final double birdVelocity = 3;
    public static final int birdX = 300;
    public static final int birdY = 300;
    public static final int pipeHeight = 70;
    public static final int space = 170;
    public static final int distance = 100;
    public static final File start = new File("src/resourses/music.mp3");
    public static MP3Player mp3player ;
}
