package com.cardgame.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BoardManager {
	
	DeckManager deck;
	Player one;
	Player two;
	
	boolean pickHand,deckEmpty;
	
	public BoardManager(){
		deck = new DeckManager();
		initBoard();
	}
	
	public BoardManager(long seed){
		deck = new DeckManager(seed);
		initBoard();
	}
	
	private void initBoard(){
		one = new Player();
		two = new Player();
		for(int i = 0; i<4;i++){
			one.addHand(deck.deal(),0);
			two.addHand(deck.deal(),0);
		}
		for(int i = 0; i<4;i++){
			one.addHand(deck.deal(),3);
			two.addHand(deck.deal(),3);
		}
		for(int i = 0; i<4;i++){
			one.addHand(deck.deal(),0);
			two.addHand(deck.deal(),0);
		}
	}
	
	public void drawBoard(SpriteBatch sb,int mask){
		if(mask == 1){
			one.drawPlayer(sb,mask,10);
			two.drawPlayer(sb,mask,393);
		}
		else{
			one.drawPlayer(sb,mask,393);
			two.drawPlayer(sb,mask,10);
		}
		sb.draw(Sprite.getCard(Sprite.BACK),640/2-50/2,480/2-73/2,50,73);
	}
	
	public long getSeed(){
		return deck.getSeed();
	}
	
}
