package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


// 직렬화 필요! 아니면 오류
// 직렬화(Serialization) -> 스트림을 통해 객체가 이동될때 객체안의 데이터(필드)가 연속된 바이트 형태로 바뀌어 전송되는 작업
// 메소드는 전송이 안된다!
// 직렬화 조건: Serializable 인터페이스 구현
class Card implements Serializable{
	private int num;
	private String name;
	
	public Card(int num, String name) {
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

public class CardSave {
	public static void main(String[] args) throws Exception{
		Card mycard = new Card(123,"tommy lee");
		
		
		//file에 객체 저장
		FileOutputStream fos = new FileOutputStream("tmp.txt");		//node Stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);		//process Stream
		oos.writeObject(mycard);									// 객체를 write한다
		
		fos.close();
		oos.close();
		
		//file에서 읽어오기;
		FileInputStream fis = new FileInputStream("tmp.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Card newcard = (Card) ois.readObject();
		
		System.out.println(newcard.getNum());
		System.out.println(newcard.getName());
		
		ois.close();
		fis.close();
	}
}
