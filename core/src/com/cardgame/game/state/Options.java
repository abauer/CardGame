package com.cardgame.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.cardgame.game.state.GameStateManager;

public class Options extends GameState{
	
	
	public Options(GameStateManager gsm) {
		super(gsm);
	}

	public void handleInput(float dt) {
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			gsm.popState();
			return;
        }
	}

	public void update(float dt) {
		handleInput(dt);
	}

	public void render() {
//		Gdx.gl.glClearColor(0, 0, 0, 1);
//		cam.setToOrtho(false,320,240);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
//		sb.setColor(Color.CLEAR);
//		sb.draw(DavesDailyRitual.getSprite("city.png",9,1), 1*16, 1*16+32);
		new BitmapFont().draw(sb,"Press Escape to return",300,300);
//		sb.setColor(Color.BLUE);
//		font.draw(sb,"Paused",0,480/2-10);
		sb.end();
		
//		sr.setProjectionMatrix(cam.combined);
//		sr.begin(ShapeType.Line);
//		sr.setColor(Color.GREEN);
//		sr.rect(0, 225, 40, 15);
//		sr.end();
	}

	public void dispose() {
	}

}

