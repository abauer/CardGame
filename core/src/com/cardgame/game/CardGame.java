package com.cardgame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.cardgame.game.state.GameStateManager;

public class CardGame extends ApplicationAdapter {
//	Texture img;
//	img = new Texture("badlogic.jpg");
	//167 x 244
	SpriteBatch sb;
	TextureRegion region;
	OrthographicCamera cam;
	BitmapFont font9;
	
	public static int WIDTH = 640;
	public static int HEIGHT = 480;
	public static int SCALE = 4;
	public static String TITLE = "Guard Games";
	
	public static final float STEP = 1/60f;
	private float accum;
	public static int count = 0;
	public static GameStateManager gsm;
	
	
	public OrthographicCamera getCamera(){return cam;}
	public SpriteBatch getSpriteBatch() {return sb;}
	public BitmapFont getTitleFont() {return font9;}
	
	@Override
	public void create () {
		cam = new OrthographicCamera();
		cam.setToOrtho(false, WIDTH, HEIGHT);
		sb = new SpriteBatch();
		FileHandle f = Gdx.files.internal("title.ttf");
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(f);
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 20;
		font9 = generator.generateFont(parameter);
		generator.dispose();
		gsm = new GameStateManager(this);
	}
	
	@Override
	public void render () {
		accum += Gdx.graphics.getDeltaTime();
		while(accum>=STEP){
			accum-= STEP;
			count++;
			gsm.update(STEP);
			gsm.render();
		}
	}
}
