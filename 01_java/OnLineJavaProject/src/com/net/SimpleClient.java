package com.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//Client
/**
 * 1. Socket(IP address, Port) 생성
 * 2. Socket으로부터 입출력 스트림 얻어냄
 * 3. 스트림으로 메세지 전송
 * 4. Socket 닫기(close())
 * 5. 스트림 닫기
 */
public class SimpleClient {
	public static void main(String[] args) throws Exception {
				
		Socket socket;
		
		InputStream in;
		DataInputStream dis;		
		
		socket = new Socket("localhost",3000);
		//socket = new Socket("172.17.219.129",3000);
		
		in = socket.getInputStream();
		dis = new DataInputStream(in);
		
		String msg = dis.readUTF();
		System.out.println(msg);
		
		// 서버로 출력
		OutputStream out; //노드스트림
		DataOutputStream dos; //필터스트림
		
		out = socket.getOutputStream(); 
		dos = new DataOutputStream(out); 
		dos.writeUTF("공격중");
		
		in.close();
		dis.close();
		
		dos.close();
		out.close();
		
		socket.close();
		
	}
}

