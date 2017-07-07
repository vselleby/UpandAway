package com.mygdx.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.view.states.GameStateManager;
import com.mygdx.game.view.states.MenuState;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	//public static final int WIDTH = Gdx.graphics.getWidth();
	//public static final int HEIGHT = Gdx.graphics.getHeight();

	public static final String TITLE = "Up and Away";

	SpriteBatch batch;
	Texture img;
	private GameStateManager gsm;
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(0, .2f, 0, 1);
		gsm.push(new MenuState(gsm));

	}



	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
