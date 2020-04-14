package com.ssafy.step01.recursive;

public class L01_LinkedListTest {

	public static void main(String[] args) {
		
		SimpleLinkedList list = new SimpleLinkedList();
		list.addFirstNode("∫Œ±«≥≤");
		list.printList();
		list.addFirstNode("¿Ãµø»÷");
		list.printList();
		list.addFirstNode("∏∆±‚");
		list.printList();
		
		System.out.println(list.getNode("∫Œ±«≥≤"));
		System.out.println(list.getNode("¿Ãµø»÷"));
		System.out.println(list.getNode("∏∆±‚"));
	}

}
