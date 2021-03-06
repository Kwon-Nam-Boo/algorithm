package com.collection;

import java.util.ArrayList;

class Member{
	String num, name;

	public Member(String num, String name) {
		this.num = num;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + "]";
	}
		
}

public class ArrayListCopyTest {

	public static void main(String[] args) {
		ArrayList<Member> src = new ArrayList<>();
		ArrayList<Member> dest = new ArrayList<>();
		ArrayList<String> src2 = new ArrayList<>();
		ArrayList<String> dest2 = new ArrayList<>();
		
		src.add(new Member("1", "tom"));
		src.add(new Member("2", "jane"));
		
		src2.add("a");
		src2.add("b");
		
		// 얕은 복사
		//dest =src;
		
		// 깊은 복사
		dest.addAll(src);		// 값만 복사
		Member m = src.get(0);
		m.name = "queen";		// 하지만 리스트안의 내용까지는 깊은 복사가 아니다!
		
		// 깊은 복사 객체
		//dest = (ArrayList<Member>) src.clone();
		
		src.add(new Member("3", "park"));
		src2.add("c");
		
		for (Member s: src) {
			System.out.println(s.name);
		}
		System.out.println("--------------------- ");
		for (Member s : dest) {
			System.out.println(s.name);
		}
		
	}

}
