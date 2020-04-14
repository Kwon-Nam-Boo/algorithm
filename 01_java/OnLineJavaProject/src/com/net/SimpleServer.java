package com.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//server
/**
 * 1. ServerSocket(port) 생성
 * 2. ServerSocket.accept():클라이언트가 접속해오기를 기다렸다가 받는 메소드-->Socket이 들어옴(socket)
 * 3. Socket으로부터 입출력 스트림 얻어냄
 * 4. 스트림으로 메세지 전송
 * 5. Socket 닫기(close())
 * 6. 스트림 닫기
 */
public class SimpleServer {
	public static void main(String[] args) throws Exception {
		
		ServerSocket server; //서버역할객체
		Socket socket; // 서버로 접속해 들어온 클라이언트를 받을 객체
		
		OutputStream out; //노드스트림
		DataOutputStream dos; //필터스트림
		InputStream in;
		DataInputStream dis;	
		
		String message ="I'M SERVER..."; //클라이언트한테 보낼 메세지
		
		// 1. 서버소켓 생성
		server = new ServerSocket(3000);
		while(true) {
			System.out.println("socket를 기다리는중 ...");
			
			// 2. 클라이언트가 접속해 오기를 기다림 + 받음.block되는 특징
			socket = server.accept();
			System.out.println("클라이언트 접속!");
			
			out = socket.getOutputStream(); // 출력용스트림 얻어냄
			dos = new DataOutputStream(out); // filter
			
			dos.writeUTF(message);
			
			//
			in = socket.getInputStream();
			dis = new DataInputStream(in);
			String msg = dis.readUTF();
			System.out.println(msg);
			
			//dos.close();
			//out.close();
			
			//socket.close();
		}
		//server.close();
	}
}
