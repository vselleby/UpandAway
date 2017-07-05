package com.mygdx.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Porpor on 05/07/2017.
 */

public class PaddleHandler {
    private ArrayList<Paddle> list;

    public PaddleHandler() {
        list = new ArrayList();

    }

    public void generatePaddle(float hspeed, float vspeed, Texture paddleTexture, float width) {
        Random rand = new Random();
        float xPos = rand.nextFloat() * 10;//*Gdx.graphics.getWidth();
        Paddle pad = new Paddle(xPos, /*Gdx.graphics.getHeight() / 2*/ 100, width, hspeed, vspeed, paddleTexture);
        list.add(pad);
    }

    public void updatePaddles(float dt) {
        for(Paddle p : list) {
            p.Update(dt);
            if(p.atBottom()) {
                p.getMyTexture().dispose();
                list.remove(p);
            }
        }
    }

    public void drawPaddles(SpriteBatch sb) {
        //sb.begin();
        for (Paddle p : list) {
            sb.draw(p.getMyTexture(), p.getX(), p.getY(), p.getX() + p.getWidth(), p.getY() + p.getHeight());
        }
        //sb.end();
    }

}
