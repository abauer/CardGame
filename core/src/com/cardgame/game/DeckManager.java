package com.cardgame.game;

import java.util.Random;
import java.util.Stack;

public class DeckManager {
	
	Random r;
	long seed;
	private int cardsLeft;
	private Stack<Integer> cards;
	
	public DeckManager(){
		seed = 1497L;//System.currentTimeMillis();
		r = new Random(seed);
		init();
	}
	
	public DeckManager(long seed){
		r = new Random(seed);
		init();
	}
	
	private void init(){
		cardsLeft = 52;
		int[] temp = new int[52];
		cards = new Stack<Integer>();
		for(int i =0; i<52; i++){
			temp[i]=i+1;
		}
		for(int i = 0; i<52; i++){
			int t = r.nextInt(52-i);
			cards.push(temp[t]);
			temp[t]=temp[51-i];
		}
		////****************************************
		Stack<Integer> read = new Stack<Integer>();
		for(int i = 0; i<52; i++){
			read.push(cards.pop());
			System.out.print(read.peek()+" ");
		}
		
		for(int i = 0; i<52; i++){
			cards.push(read.pop());
		}
		//****************************************
	}
	
	public int deal(){
		cardsLeft--;
		return cards.pop();
	}
	
	public long getSeed(){
		return seed;
	}
}
