package com.mygdx.game.view.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.model.Paddle;
import com.mygdx.game.model.PaddleHandler;

/**
 * Created by viktor on 2017-06-28.
 */

class PlayState extends State {

    private PaddleHandler ph;
    private float currentTimer;
    private final float timer = 1;
    private Paddle pad;
    private Texture bg;

    public PlayState(GameStateManager gsm) {

        super(gsm);


        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        cam.setToOrtho(false, 100, 100 * (w / h)); //this is not pixels, but whatever we choose to divide the screen into, we multiply height by aspect ratio to get everything correct.
        cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
        cam.update();
        ph = new PaddleHandler();
        currentTimer = timer;
        bg = new Texture("BackgroundBasic.png");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        if(currentTimer > 0) {
            currentTimer -= dt;
        } else {
            currentTimer = timer;
            ph.generatePaddle(20, 8, new Texture("Floor.png"), 75);
        }
        ph.updatePaddles(dt);
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, 0, 0, 100, 100);
        ph.drawPaddles(sb);

        //pad.mySprite.draw(sb);
        //sb.draw(pad.getMyTexture(), pad.getX(), pad.getY(), pad.getWidth(), pad.getHeight());
        sb.end();
    }
}
