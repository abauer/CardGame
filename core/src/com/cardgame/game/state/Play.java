package com.cardgame.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.cardgame.game.BoardManager;
import com.cardgame.game.DeckManager;
import com.cardgame.game.server.CardClient;
import com.cardgame.game.server.CardServer;
import com.cardgame.game.server.Connection;

public class Play extends GameState {
	
	public final static int PORT = 8900;
	
	Connection c;
	boolean connected;
	BoardManager game;
	int mask;
	
	
	public Play(GameStateManager gsm,String address){
		super(gsm);
		connected = false;
		mask = 2; //Player 2
		System.out.println("starting client");
		c = new CardClient(address,PORT);
		c.start();
		long t = Long.valueOf(c.getString());
		System.out.println("lets make a deck");
		game = new BoardManager(t);
		connected = true;
		System.out.println("\nLets Play a game!");
	}
	
	public Play(GameStateManager gsm){ 
		super(gsm);
		connected = false;
		mask = 1; //Player 1
		System.out.println("starting server");
		c = new CardServer(PORT);
		c.start();
		game = new BoardManager();
		c.sendString(((Long)game.getSeed()).toString());
		connected = true;
		System.out.println("\nLets Play a game!");
	}
	
	public void handleInput(float dt){
//		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
//			gsm.pushState(GameStateManager.PAUSE);
//			return;
//        }
//		int[] a = new int[2];
//		a[0]=a[1]=0;
//		if(Gdx.input.isKeyPressed(Input.Keys.A)){
//			a[0]-=1;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.D)){
//        	a[0]+=1;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.W)){
//        	a[1]-=1;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.S)){
//        	a[1]+=1;
//        }
	}
	
	public void update(float dt){
		handleInput(dt);
	}
	
	public void render(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();
		titleFont.draw(sb, "TEST", 200, 400);
		if(!connected)
			drawConnectionInfo();
		else
			game.drawBoard(sb, mask);
		sb.end();
	}

	private void drawConnectionInfo(){
		c.draw(sb,titleFont);
		c.showAddress(sb, titleFont);
	}
	public void dispose(){}
	
}
