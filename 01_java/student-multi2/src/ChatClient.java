
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatClient extends JFrame implements Runnable, ActionListener {
	 
	private DataOutputStream dos;
	private DataInputStream dis;
	
	private  JTextArea      output;
	private  JTextField      input;
	private  JLabel           label;
	private  Thread          listener;
	private  String            host;
	boolean first = true;
	
	public void connect(String server) {
		host = server;
		try {
		//network 작업...
			Socket socket = new Socket(server, 9830);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			dos = new DataOutputStream (out);	
			dis = new DataInputStream(in);	
			
		}catch(Exception w) {
			w.printStackTrace();
		}
		
		//입력용 thread 준비
		listener = new Thread(this);
		listener.start();
	}
	
	public void makeGUI () {	
		setTitle("client");
		output = new JTextArea ();
		getContentPane().add (new JScrollPane(output), "Center");
		output.setEditable (false);
		Panel bottom = new Panel();
		label = new JLabel("사용자 이름");
		bottom.add(label);
		// 채팅 내용 입력칸
		input = new JTextField (20);	
		input.addActionListener(this);
		bottom.add(input);
				
		getContentPane().add(bottom, "South");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		
		// 커서가 input으로 가있도록
		input.requestFocus();
	}
	
	
	public void run () {//입력용
		try {
			while(true) {
				String msg = dis.readUTF();
				output.append(msg + "\n");
			}
			//입력	
		} catch (Exception ex) {}
	}

	public void actionPerformed (ActionEvent e) {//출력. 이벤트처리 메소드
		
		try {
			//출력
			// 입력칸의 값 알아내기
			String id = input.getText();
			dos.writeUTF(id);
			
			if(first) {//맨처음이면
				label.setText("메시지");
				setTitle(id);	// 채팅창 타이틀바에 사용자 id 세팅
				first = false;
			}
			
		} catch (Exception e1) {				
			e1.printStackTrace();
		}
		input.setText ("");		
	}
	
	public static void main(String args[]) {
		ChatClient c = new ChatClient();	
		// 화면 
		c.makeGUI();
		// 네트워크
		c.connect("localhost");		
	}
}
