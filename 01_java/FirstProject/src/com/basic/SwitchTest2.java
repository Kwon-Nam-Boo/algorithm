package com.basic;

public class SwitchTest2 {
	public static void main(String[] args) {
		char code = 'A';
		switch (code) {
		case 'A':
		case 'a':
			System.out.println("east!");
			break;
		case 'B':
		case 'b':
			System.out.println("west!");
			break;
		case 'C':
		case 'c':
			System.out.println("south!");
			break;
		default:
			System.out.println("north!");
			break;
		}
	}
		
}
