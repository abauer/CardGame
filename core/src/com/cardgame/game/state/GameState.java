package com.cardgame.game.state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cardgame.game.CardGame;
import com.cardgame.game.state.GameStateManager;

public abstract class GameState {
	
	protected GameStateManager gsm;
	protected CardGame game;
	protected SpriteBatch sb;
	protected OrthographicCamera cam;
	protected BitmapFont titleFont;
	
	protected GameState(GameStateManager gsm){
		this.gsm = gsm;
		game = gsm.game();
		sb = game.getSpriteBatch();
		cam = game.getCamera();
		titleFont = game.getTitleFont();
	}
	
	public abstract void handleInput(float dt);
	public abstract void update(float dt);
	public abstract void render();
	public abstract void dispose();

}
