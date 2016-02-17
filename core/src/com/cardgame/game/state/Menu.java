package com.cardgame.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.cardgame.game.state.GameStateManager;

public class Menu extends GameState {

	int select = 0;
	
	public Menu(GameStateManager gsm){
		super(gsm);
		cam.update();
		float r = 82f;
		float g = 70f;
		float b = 24f;
		titleFont.setColor(r/255.0f, g/255.0f, b/255.0f, 1f);
	}
	
	public void handleInput(float dt){
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			switch(select){
				case 0: gsm.popState();
						gsm.pushState(GameStateManager.PLAY); break;
				case 1: gsm.pushState(GameStateManager.OPTIONS); break;
				case 2: //gsm.pushState(GameStateManager.ABOUT); break;
				case 3: System.exit(0); break;	
			}
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
			select--;
//			y++;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
			select++;
//			y--;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
//			x--;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
//			x++;
		}
		if(select<0) select +=4;
		else select%=4;
//		System.out.println("["+x+", "+y+"]");
	}
	
	public void update(float dt){
		handleInput(dt);
	}
	
	public void render(){
		cam.setToOrtho(false, 640, 480);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
//		sb.draw(new Texture("MainMenu.png"),0,0);
		switch(select){
			case 0: titleFont.draw(sb, "Play", 320-4*32+5, 240-5); break;// sb.draw(Sprite.getSprite(Sprite.sprites, 120), 195,201); break;
			case 1: titleFont.draw(sb, "Options", 320-4*32+5, 240-5); break;// sb.draw(Sprite.getSprite(Sprite.sprites, 120), 197,184); break;
			case 2: titleFont.draw(sb, "About", 320-4*32+5, 240-5); break;// sb.draw(Sprite.getSprite(Sprite.sprites, 120), 197,184); break;
			case 3: titleFont.draw(sb, "Exit", 320-4*32+5, 240-5); break;// sb.draw(Sprite.getSprite(Sprite.sprites, 120), 199,167); break;
		}
//		sb.draw(Sprite.getSprite(Sprite.sprites,128),640-(3)*Sprite.SSIZE,480-(1)*Sprite.SSIZE);
//		sb.draw(Sprite.getSprite(Sprite.sprites,129),640-(1)*Sprite.SSIZE,480-(1)*Sprite.SSIZE);
//		sb.draw(Sprite.getSprite(Sprite.sprites,129),640-(2)*Sprite.SSIZE,480-(1)*Sprite.SSIZE);
//		
//		sb.draw(Sprite.getSprite(Sprite.sprites,138),640-(3)*Sprite.SSIZE,480-(2)*Sprite.SSIZE);
//		sb.draw(Sprite.getSprite(Sprite.sprites,139),640-(1)*Sprite.SSIZE,480-(2)*Sprite.SSIZE);
//		sb.draw(Sprite.getSprite(Sprite.sprites,139),640-(2)*Sprite.SSIZE,480-(2)*Sprite.SSIZE);
		
		titleFont.draw(sb, "WSAD to move\n      Space \n    to select", 640-4*32+5, 480-5);
		sb.end();
	}
	
	public void dispose(){}
	
}
