package com.mygdx.game.view.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.Paddle;
import com.mygdx.game.model.PaddleHandler;

import static com.mygdx.game.view.MyGdxGame.HEIGHT;
import static com.mygdx.game.view.MyGdxGame.WIDTH;

/**
 * Created by viktor on 2017-06-28.
 */

class PlayState extends State {

    private PaddleHandler ph;
    private float currentTimer;
    private final float timer = 1;

    public PlayState(GameStateManager gsm) {

        super(gsm);

        cam.setToOrtho(false, WIDTH / 2, HEIGHT / 2);
        ph = new PaddleHandler();
        ph.generatePaddle(5, 8, new Texture("ButtonPlayUpAndAway.png"), 10);
        currentTimer = timer;
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
            ph.generatePaddle(5, 8, new Texture("ButtonPlayUpAndAway.png"), 10);
        }
        ph.updatePaddles(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        ph.drawPaddles(sb);
        sb.end();
    }
}
