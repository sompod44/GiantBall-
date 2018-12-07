/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giantball;



/**
 *
 * @author Sompod_Programmer
 */
public class Multi_Balls { 
    private int x;
    private int y;
    private int speedX;
    private int speedY;
    int speed = 10;
    private int radius;
    private boolean LiveOrDie;
    
    public Multi_Balls(int x,int y,int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
        LiveOrDie = true;
        speedX = speed;
        speedY = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isLiveOrDie() {
        return LiveOrDie;
    }

    public void setLiveOrDie(boolean LiveOrDie) {
        this.LiveOrDie = LiveOrDie;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    
    
    
}
