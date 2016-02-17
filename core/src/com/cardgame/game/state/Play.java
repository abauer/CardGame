package com.cardgame.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.cardgame.game.CardGame;
import com.cardgame.game.state.GameStateManager;

public class Play extends GameState {
	
	boolean paused = false;
	int pauseTime = 0;
	
	public Play(GameStateManager gsm){
		super(gsm);
	}
	
	public void handleSpace(float dt){
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			gsm.pushState(GameStateManager.PAUSE);
			return;
        }
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
			if(CardGame.count-pauseTime>5)
				paused = false;
	}
	
	public void handleInput(float dt){
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			gsm.pushState(GameStateManager.PAUSE);
			return;
        }
		int[] a = new int[2];
		a[0]=a[1]=0;
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			a[0]-=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
        	a[0]+=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
        	a[1]-=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
        	a[1]+=1;
        }
	}
	
	public void update(float dt){
		if(!paused){
			handleInput(dt);
		}
		else{
			handleSpace(dt);
		}
	}
	
	public void render(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();		

		sb.end();
	}
	
	public void dispose(){}
	
}
