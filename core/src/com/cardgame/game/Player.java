package com.cardgame.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
	
	ArrayList<Integer> hand;
	ArrayList<Integer> vis;
	
	public Player(){
		hand = new ArrayList<Integer>();
		vis = new ArrayList<Integer>();
	}
	
	public void addHand(int card, int visibilty){
		hand.add(card);
		vis.add(visibilty);
	}
	
	public void drawPlayer(SpriteBatch sb, int mask, int y){
//		System.out.println("*****");
		for(int i = 0; i<hand.size(); i++){
			if((vis.get(i) & mask)>0){
//				System.out.println(hand.get(i));
				sb.draw(Sprite.getCard(hand.get(i)), i*640/hand.size(),y,50,73);
			}
			else{
//				System.out.println("back");
				sb.draw(Sprite.getCard(Sprite.BACK), i*640/hand.size(),y,50,73);
			}
		}
	}
}
