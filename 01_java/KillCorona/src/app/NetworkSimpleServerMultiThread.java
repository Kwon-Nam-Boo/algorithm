package app;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class SimpleServerThread extends Thread{
	private Socket socket;

	public SimpleServerThread(Socket s) {
		this.socket = s;
	}
	public void run() {
		try {
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output,true);
			writer.println("Hello SSAFY thread!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}


public class NetworkSimpleServerMultiThread {
	public static void main(String[] args) {
		int port = 4101;
		
		try(ServerSocket serverSocket = new ServerSocket(port)){
			System.out.println("NetworkSimpleServerMultiThread start");
			while(true) {
				Socket socket = serverSocket.accept();
				new SimpleServerThread(socket).start();
			}
			
			
		}catch(IOException e) {
			System.out.println("NetworkSimpleServerMultiThread exception " + e.getMessage());
			e.printStackTrace();
		}
	}
}
