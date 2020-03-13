package game.image;

import java.awt.image.BufferedImage;

public class Asset {
    public static BufferedImage background, bird1, bird2, bird3, bird4, pipe1, pipe2,
    zero, one, two, three, four, five, six, seven, eight, nine,
    gameover, star;
    public static void init(){
        background = ImageLoader.loadImage("/resourses/background.png");
        bird1 = ImageLoader.loadImage("/resourses/bird1.png");
        bird2 = ImageLoader.loadImage("/resourses/bird2.png");
        bird3 = ImageLoader.loadImage("/resourses/bird3.png");
        bird4 = ImageLoader.loadImage("/resourses/bird4.png");
        pipe1 = ImageLoader.loadImage("/resourses/pipe1.png");
        pipe2 = ImageLoader.loadImage("/resourses/pipe2.png");
        zero = ImageLoader.loadImage("/resourses/0.png");
        one = ImageLoader.loadImage("/resourses/1.png");
        two = ImageLoader.loadImage("/resourses/2.png");
        three = ImageLoader.loadImage("/resourses/3.png");
        four = ImageLoader.loadImage("/resourses/4.png");
        five = ImageLoader.loadImage("/resourses/5.png");
        six = ImageLoader.loadImage("/resourses/6.png");
        seven = ImageLoader.loadImage("/resourses/7.png");
        eight = ImageLoader.loadImage("/resourses/8.png");
        nine = ImageLoader.loadImage("/resourses/9.png");
        gameover = ImageLoader.loadImage("/resourses/gameover.png");
        star = ImageLoader.loadImage("/resourses/star.png");
    }
}
