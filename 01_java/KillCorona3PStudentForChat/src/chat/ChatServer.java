package chat;

import java.io.*;
import java.net.*;
import java.util.*;


public class ChatServer{

	private ArrayList<ChatThread> chatThreadList = new ArrayList<ChatThread>();
	private int port = 4101;
	
	public void service() {
		
		try (ServerSocket ss = new ServerSocket(port);) {

			System.out.println("ChatServer 가 준비되었습니다. 접속 포트는 " + port + " 입니다.");

			while (true) {

				// 코드를 함께 작성해 봅시다.
				Socket s = ss.accept();
				System.out.println("ChatClient 가 접속했습니다.");
				
				// 스레드에 소켓 전달
				ChatThread t = new ChatThread(s);
				// 스레드를 리스트에 담아두기
				chatThreadList.add(t);
				// 스레드 시작
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void broadcast( String message ) {
		// 코드를 함께 작성해 봅시다.
		// 모든 스레드에게 sendmessage 호출
		for (ChatThread t : chatThreadList) {
			try {
				t.sendMessage(message);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) 	{
		// 챗서버의 서비스를 호출한다.
		new ChatServer().service();
	}

	class ChatThread extends Thread {

		private Socket socket;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		private boolean isExit = false;
		
		public ChatThread(Socket socket) throws Exception {
			this.socket = socket;
			this.ois = new ObjectInputStream(socket.getInputStream());
			this.oos = new ObjectOutputStream(socket.getOutputStream());
		}

		public void run() {
			try {
				// 클라이언트로 부터 날라오는 메세지를 처리한다.
				while ( ! isExit ) {
					// 코드를 함께 작성해 봅시다.
					// 메세지를 받는다.
					String msg =(String) ois.readObject();
					
					// 종료 조건
					if("^".equals(msg)) {
						chatThreadList.remove(this);
						isExit = true;
					}else {
						// 브로드캐스트 호출
						broadcast(msg);
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				chatThreadList.remove(this);
			}
		}
		// 클라이언트에 메세지를 보낸다. 언제보낼까? 브로드캐스트가 호출될때 각자 담당하는 클라이언트에게 보내야지
		public void sendMessage(String message) throws Exception {
			// 코드를 함께 작성해 봅시다.
			oos.writeObject(message);
		}
	}
}
