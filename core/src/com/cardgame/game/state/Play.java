package com.cardgame.game.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.cardgame.game.server.CardClient;
import com.cardgame.game.server.CardServer;

public class Play extends GameState {
	
	public final static int PORT = 8900;
	
	boolean connected;
	CardServer cs;
	CardClient cc;
	public Play(GameStateManager gsm,String address){
		super(gsm);
		connected = false;
		System.out.println("starting client");
		cc = new CardClient(address,PORT);
		cc.start();
		System.out.println("continuing on");
		
		//connect
		
		//do stuff
	}
	
	public Play(GameStateManager gsm){
		super(gsm);
		connected = false;
		System.out.println("strating server");
		cs = new CardServer(PORT);
		cs.start();
		System.out.println("continuing");
		//start server
		//show IP
		//setup deck
		
		//wait for connection
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
		if(!connected){
			//connect 
			return;
		}
		handleInput(dt);
	}
	
	public void render(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.begin();
		titleFont.draw(sb, "TEST", 200, 400);
		drawServer();
		drawClient();
		sb.end();
	}
	
	private void drawServer(){
		if(cs!=null)
			cs.draw(sb,titleFont);
	}
	private void drawClient(){
		if(cc!=null)
			cc.draw(sb,titleFont);
	}
	public void dispose(){}
	
}
