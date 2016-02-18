package com.cardgame.game.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class CardClient extends Connection{
	
	String address;
	
	public CardClient(String address,int port){
		super(port);
		this.address = address;
	}
	
	protected void setupConnection(){
		try {
			connection = new Socket(address,port);
			bread = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			bwrite = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			bwrite.write(connection.getLocalAddress().getHostAddress()); bwrite.newLine();
			connected = true;			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
