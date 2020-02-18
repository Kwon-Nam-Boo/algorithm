package com.collection;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class HashMapTest {

	public static void main(String[] args) {
		TreeMap<String, String> t= new TreeMap<>();
		t.put("이름", "부권남");
		t.put("num", "123");
		t.put("City", "Seoul");
		t.put("1", "2222");
		t.put("10", "5555");
	
		System.out.println(t);
		System.out.println(t.firstKey());
		System.out.println(t.lastKey());
		System.out.println(t.higherKey("C"));
		System.out.println(t.lowerKey("C"));
		System.out.println();
		
		HashMap<String, String> map = new HashMap<>();
		map.put("num", "123");
		map.put("name", "june");
		map.put("address", "seoul");
		map.put("name", "billy");
		
		System.out.println(map);
		String name = map.get("name");
		System.out.println(name);

		Set<String> keys = map.keySet(); //map안의 key만 추출해서 set으로 return;
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
	}

}
