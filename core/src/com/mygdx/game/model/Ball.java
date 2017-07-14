package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by viktor on 2017-06-28.
 */

public class Ball {
    private Texture ballTexture;
    private int radius;
    private float xPos, yPos, jumpSpeed, gravity, vspeed;
    private Sprite mySprite;

    public Ball(Texture texture, int radius, float yPos, float gravity) {
        ballTexture = texture;
        this.radius = radius;
        this.yPos = yPos;
        xPos = 0; /* Should be middle of screen */
        this.jumpSpeed = 0;
        this.gravity = gravity;
        vspeed = gravity;
    }

    public boolean isDead() {
        return yPos <= 0;
    }

    public void jump() {
        jumpSpeed = -10;
    }

    public void update(float dt) {

        /**AABB Axis aligned bounding box/
        jumpSpeed += gravity;
        yPos += jumpSpeed;*/

    }



}

