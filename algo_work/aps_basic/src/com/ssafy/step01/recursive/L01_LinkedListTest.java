package com.ssafy.step01.recursive;

public class L01_LinkedListTest {

	public static void main(String[] args) {
		
		SimpleLinkedList list = new SimpleLinkedList();
		list.addFirstNode("�αǳ�");
		list.printList();
		list.addFirstNode("�̵���");
		list.printList();
		list.addFirstNode("�Ʊ�");
		list.printList();
		
		System.out.println(list.getNode("�αǳ�"));
		System.out.println(list.getNode("�̵���"));
		System.out.println(list.getNode("�Ʊ�"));
	}

}
