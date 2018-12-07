package giantball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Sompod_Programmer
 */
public class PaintBallPanel extends JPanel implements ActionListener {

    private Timer timer;
    private static int timelaps = 50;
    Multi_Balls Ball[] = new Multi_Balls[20]; // Here we create 20 ball object
    private Random random = new Random(); // this is use for genarate random number from a range

    public PaintBallPanel() { // this is class constractor that call one time. when object are create
        timer = new Timer(timelaps, this); // here we create timer class's object. 
        timer.start(); // here timer are start 
        /*
        Ball[0] mean this is first ball that we place this into middle position..
        */
        Ball[0] = new Multi_Balls(GiantBall.Width / 2 - 80, GiantBall.Height / 2 - 80, 80); // here we set middle red big ball position
        // using this loof for set another 19 ball position
        for (int i = 1; i < 20; i++) {
            Ball[i] = new Multi_Balls(random.nextInt(GiantBall.Width - 50), random.nextInt(GiantBall.Height - 50), 25);
        }
    }

    @Override
    protected void paintComponent(Graphics g) { // this is build in function for paint diffrent element into Panel
        super.paintComponent(g); // this is parent class constructor method.
        g.setColor(Color.red); // here set ball color Red for middle ball
        g.fillOval(Ball[0].getX(), Ball[0].getY(), Ball[0].getRadius(), Ball[0].getRadius()); // here we paint red ball into middle position
        
        for (int i = 1; i < 20; i++) { // Into this  loop we paint 19 green ball 
            if (Ball[i].isLiveOrDie()) {
                g.setColor(Color.green);
                g.fillOval(Ball[i].getX(), Ball[i].getY(), Ball[i].getRadius(), Ball[i].getRadius());
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) { // after sudden time the timer class call this method 
        double d1, d2, x1, x2, y1, y2, x, y, d3, d4; // those variable are use for store distance and ball center x&y position
        
        //this loop are use for movement our ball 
        for (int i = 1; i < 20; i++) {
            Ball[i].setX(Ball[i].getX() + Ball[i].getSpeedX()); // here we change ith ball x position
            Ball[i].setY(Ball[i].getY() + Ball[i].getSpeedY()); // here we change ith ball y positon 
            if (Ball[i].getX() < 0 || Ball[i].getX() > GiantBall.Width - 50) { // here we check ball are out of range or not
                Ball[i].setSpeedX(-Ball[i].getSpeedX()); // we set negetive value so that ball can back 
            }
            if (Ball[i].getY() < 0 || Ball[i].getY() > GiantBall.Height - 50) { // here we check ball are out of range or not 
                Ball[i].setSpeedY(-Ball[i].getSpeedY()); // we set negetive value so that ball can back
            }

            x1 = Ball[0].getX() + Ball[0].getRadius() / 2; // x1 is middle ball center x value
            y1 = Ball[0].getY() + Ball[0].getRadius() / 2; // y1 is middle ball center y value
            
            x2 = Ball[i].getX() + Ball[i].getRadius() / 2; // x2 is ith ball center x value
            y2 = Ball[i].getY() + Ball[i].getRadius() / 2; // y2 is ith ball center y value

            d1 = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2)); // here we calculate center ball and ith ball distance
            d2 = (Ball[0].getRadius() / 2) + (Ball[i].getRadius() / 2); // here we add center ball and ith ball diameter

            if (Ball[i].isLiveOrDie()) { // here we check ith ball alive or not if alive then we check ith ball are touch or not with middle ball
                if (d1 == d2 || d1 < d2) { // its mean middle ball and ith ball hit with eachother

                    Ball[i].setLiveOrDie(false); // here we set that ith ball die
                    Ball[0].setRadius(Ball[0].getRadius() + 5); // here middle ball become fat from past size

                }
            }

            for (int j = 1; j < 20; j++) { // we use this loop for two ball distroy if two ball are hit each other
                x = Ball[j].getX() + Ball[j].getRadius() / 2; 
                y = Ball[j].getY() + Ball[j].getRadius() / 2;

                d3 = Math.sqrt(Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2));
                d4 = (Ball[i].getRadius() / 2) + (Ball[j].getRadius() / 2);

                if (Ball[i].isLiveOrDie() && Ball[j].isLiveOrDie() && i != j) {
                    if (d3 == d4 || d3 < d4) {
                        Ball[i].setLiveOrDie(false);
                        Ball[j].setLiveOrDie(false);
                    }
                }
            }

        }

        repaint(); // this method call PaintComponent 
    }

}
