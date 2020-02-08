package com.object;


class Animal{}
class Mammal extends Animal{}
class Tiger extends Mammal{}
class Tree{}


public class InstanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal t = new Mammal();
		
		
		if(t instanceof Tiger) {
			System.out.println("instanceof Tiger");
		}
		else if(t instanceof Mammal) {
			System.out.println("instanceof Mammal");
		}
		else if(t instanceof Animal) {
			System.out.println("instanceof Animal");
		}

	}

}
