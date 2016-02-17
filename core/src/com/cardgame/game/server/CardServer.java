package com.cardgame.game.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cardgame.game.CardGame;

public class CardServer extends Thread {
	
	private int port;
	Socket connection;
	ServerSocket listenSocket;
	InputStream inStream;
	DataInputStream inDataStream;
	BufferedReader d;
	OutputStream outStream;
	DataOutputStream outDataStream;
	String client;
	boolean connected;
	String draw;
	
	public CardServer(int portIn){
		port = portIn;
		connected = false;
		draw = "";
	}
	
	public void run(){
		while(true){
			if(!connected){
				try{
					listenSocket = new ServerSocket(port,0,InetAddress.getLocalHost());
					draw = "Listening on add:port "+ listenSocket.getInetAddress()+":"+port;
					System.out.println(draw);
					connection = listenSocket.accept();
					inStream = connection.getInputStream();
					inDataStream = new DataInputStream(inStream);
					d = new BufferedReader(new InputStreamReader(inStream));
					
					outStream = connection.getOutputStream();
					outDataStream = new DataOutputStream(outStream);
					String client = inDataStream.readUTF();
					draw = "Connection esablished with "+ client;
					System.out.println(draw);
					connected = true;
				}catch (IOException e){
					e.printStackTrace();
				}
			}
			else{
				String client;
				try {
					client = d.readLine();
					draw = "Client just said: "+ client;
					System.out.println("Got a message:"+draw);
				} catch (IOException e) {
					e.printStackTrace();
				}			
			}
		}
	}
	
	public void draw(SpriteBatch sb,BitmapFont bf){
		bf.draw(sb, draw, 320-4*32+5, 240-5-40);
	}
}
