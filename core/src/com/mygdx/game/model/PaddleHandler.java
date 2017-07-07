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

        float xPos = (rand.nextFloat() * (100f - width));

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        float yPos = (100 * (w/h));
        Paddle pad = new Paddle(xPos, yPos , width, hspeed ,vspeed, paddleTexture);
        list.add(pad);
    }

    public void updatePaddles(float dt) {
        for(Paddle p : new ArrayList<Paddle>(list)) {
            p.Update(dt);
            if(p.atBottom()) {
                p.mySprite.getTexture().dispose();
                p.getMyTexture().dispose();
                list.remove(p);
            }
        }
    }

    public void drawPaddles(SpriteBatch sb) {
        //sb.begin();
        for (Paddle p : new ArrayList<Paddle>(list)) {
            p.mySprite.draw(sb);

            sb.draw(p.getMyTexture(), p.getX(), p.getY(), p.getWidth(), p.getHeight());
        }
        //sb.end();
    }

}
