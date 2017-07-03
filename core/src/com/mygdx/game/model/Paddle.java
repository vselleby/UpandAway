package com.mygdx.game.model;

/**
 * Created by viktor on 2017-06-28.
 */

public class Paddle {

    protected float xPos;
    protected float yPos;
    protected float length;
    protected int speed;
    protected int direction;

    public Paddle(float xPos, float yPos, float length, int speed, int direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.length = length;
        this.speed = speed;
        this.direction = direction;
    }

    public float getX() {
        return xPos;
    }

    public float getY() {
        return yPos;
    }

    /*
    Will probably need getters and setters? for all parameters here. Implement when needed
     */
}
