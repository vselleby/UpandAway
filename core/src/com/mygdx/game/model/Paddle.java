package com.mygdx.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static com.badlogic.gdx.Gdx.graphics;

/**
 * Created by viktor on 2017-06-28.
 */

public class Paddle {

    protected float m_deltaTime; //Calculate in your core loop, get it through your state.
    protected float xPos;
    protected float yPos;
    protected float width;
    protected float height;
    protected float speed;

    protected float hspeed;
    protected float vspeed;

    protected Texture myTexture;
    protected Sprite mySprite;


    public Paddle(float xPos, float yPos, float width, float hspeed, float vspeed, Texture myTexture) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.hspeed = hspeed;
        this.vspeed = vspeed;
        this.myTexture = myTexture;
        height = 4;
        mySprite = new Sprite(myTexture);
    }

    public float getX() { return xPos; }

    public float getY() { return yPos; }

    public float getWidth() { return width; }

    public float getHeight() { return height; }

    public float gethSpeed() { return hspeed; }

    public float getvSpeed() { return vspeed; }

    public Sprite getSprite() { return mySprite; }

    public void Update(float dt)
    {
        mySprite.setPosition(xPos, yPos);
        mySprite.setSize(width, height);
        UpdateyPos(dt);
        UpdatexPos(dt);
        FlipX();
    }

    public void UpdateyPos(float dt)
    {
        yPos -= vspeed * dt;
    }

    public void UpdatexPos(float dt)
    {
        xPos += hspeed * dt;
    }


    public boolean atBottom()
    {
        return yPos <= 0-height;
    }

    public Texture getMyTexture()
    {
        return myTexture;
    }

    private void FlipX()
    {
        if ((xPos + width) >= 100 || xPos <= 0)
            hspeed = hspeed * -1;
    }

    public void Render(Texture myTexture)
    {
        //is this a copy i am passing or a reference?
    }
    /*
    Will probably need getters and setters? for all parameters here. Implement when needed
     */
}
