package ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket("127.0.0.1", 6013);
		
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String line ="";
		
		while((line = br.readLine())!= null) {
			System.out.println(line);
		}
	
		System.out.println("클라이언트 종료");
		socket.close();
	}
}
