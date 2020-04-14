package com.muitl.chat.real.stu;

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

//추가과제: ServerSocket close 시키는 부분 추가하기
//클라이언트 접속 받고, 받은 후에는 thread 생성하고 start

public class ChatServer {
	private ArrayList<ChatThread> clientList;	   

	public ChatServer (int port) {
        try {
           ServerSocket server = new ServerSocket(port);
           clientList = new ArrayList<>();
           System.out.println("Server is ready...");
           
           // 클라이언트 접속 받음
           while(true) {
        	   Socket socket = server.accept();
               ChatTread thread = new ChatThread(this, socket);
               thread.start();
           }
        } catch(Exception e) {}
    }

    public void register(ChatThread c) {   //입장
    	clientList.add(c);
    }
    
    public void unregister(ChatThread c) { //퇴장
    	clientList.remove(c);
    }
    
    // 현재 접속한 모든 클라이언트에게 해당 메세지를 방송
    //thread가 등록되어 있는 arrayList에 접근해서 모든 thread에 메세지를 전달
	public void broadcast (String message) {		
		int n = clientList.size();
		for(int i =0; i<n ;i++) {
			ChatThread t = clientList.get(i);
			try {
				t.println(message);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	

    public static void main (String args[]) {
		ChatServer server = new ChatServer(9830);			
    }
}
