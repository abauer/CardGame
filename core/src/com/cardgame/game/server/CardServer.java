package com.cardgame.game.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;

public class CardServer extends Connection {
	
	public CardServer(int port){
		super(port);
	}
	
	@SuppressWarnings("resource")
	protected void setupConnection(){
		try{
			connection = new ServerSocket(port,0,InetAddress.getLocalHost()).accept();
			bread = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			bwrite = new BufferedWriter(new OutputStreamWriter(new DataOutputStream(connection.getOutputStream())));
			connected = true;
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
