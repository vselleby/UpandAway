package com.mygdx.game.view.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by viktor on 2017-06-28.
 */

public class MenuState extends State {

    private Texture text;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        text = new Texture("Push to play");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.push(new PlayState(gsm));
        }
    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

    }
}
