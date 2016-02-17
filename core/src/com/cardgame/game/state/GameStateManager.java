package com.cardgame.game.state;

import java.util.Stack;

import com.cardgame.game.CardGame;
import com.cardgame.game.state.GameOver;
import com.cardgame.game.state.GameState;
import com.cardgame.game.state.Play;
import com.cardgame.game.state.Menu;
import com.cardgame.game.state.Options;
import com.cardgame.game.state.Pause;

public class GameStateManager {

	public CardGame game;
	private Stack<GameState> gameStates;
	public static final int PLAY = 912124;
	public static final int MENU = 314159;
	public static final int PAUSE = 12345;
	public static final int GOVER = 66666;
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
		if(state == PLAY) return new Play(this);
		if(state == MENU) return new Menu(this);
		if(state == PAUSE) return new Pause(this);
		if(state == GOVER) return new GameOver(this);
		if(state == OPTIONS) return new Options(this);
		return null;
	}
	
	public void setState(int state){
		popState();
		pushState(state);
	}
	
	public void pushState(int state){
		gameStates.push(getState(state));
	}
	
	public void popState(){
		GameState g = gameStates.pop();
		g.dispose();
	}
}
