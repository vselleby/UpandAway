package com.mygdx.game.view.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input;

/**
 * Created by viktor on 2017-06-28.
 */

public class MenuState extends State {

    private final Texture text;
    private final Texture bg;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

        bg = new Texture("BackgroundUpAndAway.png");
        text = new Texture("ButtonPlayUpAndAway.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.push(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(text, cam.position.x - (text.getWidth() / 2), cam.position.y - (text.getHeight() / 2));

        sb.end();
    }
}
