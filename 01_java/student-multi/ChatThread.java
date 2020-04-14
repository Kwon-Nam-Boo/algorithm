package com.muitl.chat.real.stu;


import java.net.*;

import java.io.*;
//접속한 클라이언트와 입출력 작업
public class ChatThread extends Thread {
	Socket socket;
	DataOutputStream dos;
	DataInputStream dis;
	ChatServer  server;
	
	public ChatThread(ChatServer server, Socket socket) throws IOException { 
		this.socket = socket;
		this.server = server;
		
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		
		dos = new DataOutputStream (out);	
		dis = new DataInputStream(in);				
	}
		
	public void run () {//읽어서 방송. 예외발생시 리스트에서 자신 제외
		String name = "";
		try {
			name = dis.readUTF();			
			//서버의 리스트에 등록
			server.register(this);
			//방송: ~님 입장했습니다
			server.broadcast(name + "님이 입장하셧습니다.");
			
			//자기가 담당하는 클라이언트로부부터 오는 입력 받아서 방송 -> 계속
			while(true) {
				String msg = dis.readUTF();
				server.broadcast(name + ">" + msg);
			}
		} catch (IOException ex) {
			
			
		}
		server.unregister(this);
		server.broadcast(name + "님이 나가셨습니다.");
			//...
			
		try {
			dis.close();
			dos.close();
			socket.close();
		} catch (IOException ex) {}
	}
	
	protected void println(String message) throws Exception {
		dos.writeUTF(message);
	}	
	
}
