package com.cardgame.game.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Connection extends Thread{
	
	protected int port;
	protected Socket connection;
	protected BufferedReader bread;
	protected BufferedWriter bwrite;
	protected boolean connected;
	protected String address;
	
	protected ArrayList<String> input;
	protected ArrayList<String> output;
	
	public Connection(int port){
		this.port = port;
		connected = false;
		input = new ArrayList<String>();
		output = new ArrayList<String>();
	}
	
	abstract protected void setupConnection();
	
	public void run(){
		if(!connected){
			setupConnection();
		}
		System.out.println("is this looping?");
		new Thread(){ public void run(){ checkOutput(); } }.start();
		checkInput();
	}
	private void checkOutput(){
		while(true){
			try {
				if(0<output.size()){
					String s = output.remove(0);
					bwrite.write(s); bwrite.newLine(); bwrite.flush();
					System.out.println("send:"+s);
				}					
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	private void checkInput(){
		while(true){
			try {				
				String s = bread.readLine();
				input.add(s);
				System.out.println("receive:"+s);
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void sendString(String s){
		output.add(s);
	}
	
	public String getString(){
		System.out.println("String requested");
		int a = input.size();
		while(a<1){a = input.size(); try {Thread.sleep(50);} catch (InterruptedException e) {e.printStackTrace();}	}
		return input.remove(0);
	}
	
	public String[] getAllString(){
		String val[] = new String[input.size()];
		for(int i = 0; i<val.length; i++){
			val[i]=input.remove(0);
		}
		return val;
	}
	
	public void draw(SpriteBatch sb,BitmapFont bf){
		String sent = (output.size()>0) ? output.get(0) : "";
		String received = (input.size()>0) ? input.get(0) : "";
		bf.draw(sb, "s:"+sent, 320-4*32+5, 240-5-40);
		bf.draw(sb, "r:"+received, 320-4*32+5,240-20);
	}
	
	public void showAddress(SpriteBatch sb,BitmapFont bf){
		bf.draw(sb, "a:"+address, 0,24);
	}
}
