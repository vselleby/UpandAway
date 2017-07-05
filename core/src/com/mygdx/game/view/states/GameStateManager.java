package com.mygdx.game.view.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by viktor on 2017-06-28.
 */

public class GameStateManager {

    private Stack<State> states;
    private State activeState;

    public GameStateManager() {
        states = new Stack<State>();
    }

    public void push(State state) {
        states.push(state);
        activeState = state;
    }

    public void pop() {
        states.pop();
        activeState = states.peek();
    }

    public void set(State state) {
        pop();
        push(state);
        activeState = state;
    }

    public void update(float dt) {
        states.peek().update(dt);
    }

    public void render(SpriteBatch batch) {
        states.peek().render(batch);
    }

}
