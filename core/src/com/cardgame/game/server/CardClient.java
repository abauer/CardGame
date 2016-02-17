package com.cardgame.game.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CardClient extends Thread{
	
	private int port;
	Socket connection;
	ServerSocket listenSocket;
	InputStream inStream;
	DataInputStream inDataStream;
	BufferedReader d;
	OutputStream outStream;
	DataOutputStream outDataStream;
	BufferedWriter b;
	String client;
	boolean connected;
	SpriteBatch sb;
	String address;
	int i = 0;
	String draw;
	
	public CardClient(String address,int port){
		this.address = address;
		this.port = port;
		draw = "";
	}
	
	public void run(){
//		while(true){
			i++;
			if(!connected){
				try {
					connection = new Socket(address,port);
					draw = "connection establish";
					System.out.println(draw);
					
					inStream = connection.getInputStream();
					inDataStream = new DataInputStream(inStream);
					d = new BufferedReader(new InputStreamReader(inStream));
					
					outStream = connection.getOutputStream();
					outDataStream = new DataOutputStream(outStream);
					b = new BufferedWriter(new OutputStreamWriter(outStream));
					
					outDataStream.writeUTF(connection.getLocalAddress().getHostAddress());
					connected = true;
					draw = "HAPPY BIRTHDAY ANTHONY!"+i;
					b.write(draw);
					System.out.println(draw);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				try {
					draw = "HAPPY BIRTHDAY ANTHONY!"+i;
					b.write(draw);
					System.out.println(draw);
					
				} catch (IOException e){
					e.printStackTrace();
				}
			}
//		}
	}
	
	public void draw(SpriteBatch sb,BitmapFont bf){
		bf.draw(sb, draw, 320-4*32+5, 240-5-40);
	}
}
