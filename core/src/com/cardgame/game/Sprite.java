package com.cardgame.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Sprite {
	public static int SHEETWIDTH=13;
	public static int BACK=55;
	public static int CARDHEIGHT = 244;
	public static int CARDWIDTH = 167;
	public static Texture cards = new Texture("sprite.png");
	
	public static TextureRegion getCard(int n){
		n-=1;
		return new TextureRegion(cards,n%SHEETWIDTH*167,n/SHEETWIDTH*244,167,244);
	}
}
