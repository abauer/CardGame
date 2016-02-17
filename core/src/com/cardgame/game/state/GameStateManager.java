package com.cardgame.game.state;

import java.util.Stack;

import com.cardgame.game.CardGame;
//import com.cardgame.game.state.GameOver;
import com.cardgame.game.state.GameState;
import com.cardgame.game.state.Play;
import com.cardgame.game.state.Menu;
import com.cardgame.game.state.Options;
//import com.cardgame.game.state.Pause;

public class GameStateManager {

	public CardGame game;
	private Stack<GameState> gameStates;
	public static final int SERVER = 912124;
	public static final int MENU = 314159;
	public static final int CLIENT = 12345;
	public static final int ABOUT = 66666;
	public static final int OPTIONS = 23232;
	
	public GameStateManager(CardGame game){
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(MENU); //first screen
	}
	
	public CardGame game() {return game;}
	
	public void handleInput(){
			
	}
	
	public void update(float dt){
		gameStates.peek().update(dt);
	}
	
	public void render(){
		gameStates.peek().render();
	}
	
	private GameState getState(int state){
		if(state == SERVER) return new Play(this);
		if(state == MENU) return new Menu(this);
//		if(state == CLIENT) return new Play(this);
		if(state == OPTIONS) return new Options(this);
		if(state == ABOUT) return new About(this);
		return null;
	}
	
	public void setState(int state){
		popState();
		pushState(state);
	}
	
	public void pushState(int state){
		gameStates.push(getState(state));
	}
	
	public void pushClient(int state,String s){
		gameStates.push(new Play(this,s));
	}
	
	public void popState(){
		GameState g = gameStates.pop();
		g.dispose();
	}
}
