package boj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test1 {

	private static Set<String> alpha = new HashSet<>();
	private static List<Integer> sub = new ArrayList<>();
	public static void main(String[] args) {
		alpha.add("A");
		alpha.add("C");
		alpha.add("E");
		System.out.println(alpha.contains("E"));
		sub.add(3);
		sub.add(13);
		sub.add(23);
		
		System.out.println(sub.indexOf(13));
		
		System.out.println(checkNum("fdsdsad01"));
		System.out.println(-17/8);
	}
	
	public static boolean checkNum(String num) {
		for (int i = 0; i < num.length(); i++) {
			if(!Character.isDigit(num.charAt(i))){		// 숫자가 아니라면 fail
				return false;
			}	
		}
		return true;
	}
}
