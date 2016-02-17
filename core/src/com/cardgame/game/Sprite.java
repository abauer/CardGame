package com.cardgame.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Sprite {
	public static int SSIZE=32;
	public static int SHEETWIDTH=10;
	public static Texture cards = new Texture("cards.png");
	public static Texture spirte = new Texture("sprites.png");
	
	public static TextureRegion getSprite(Texture s, int n){
		return getSprite(s,n%Sprite.SHEETWIDTH,n/Sprite.SHEETWIDTH);
	}
	
	public static TextureRegion getSprite(Texture s, int x, int y){
		return new TextureRegion(s, x*Sprite.SSIZE, y*Sprite.SSIZE, Sprite.SSIZE, Sprite.SSIZE);
	}
	
	public static TextureRegion getCard(int n){
		return new TextureRegion(cards,n%13*167,n/13*244,167,224);
	}
}
