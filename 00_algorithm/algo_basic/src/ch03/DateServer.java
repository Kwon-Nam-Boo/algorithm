package ch03;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DateServer  {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket server = new ServerSocket(6013);
		
		/* Now listen for connections */
		while(true) {
			System.out.println("기다리는중 ...");
			Socket client = server.accept();
			PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
			System.out.println("새로운 클라이언트와 연결 되었습니다");
			
			pout.println("회신메세지: 서버를 다녀가셨습니다! 축하합니다!");
			client.close();
		}
	}

}
