package com.lambda;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("kim", "lee","park","pyo");
		
		//기존 방식
		long cnt =0;
		for (String name: names) {
			if(name.contains("p"))
				cnt++;
		}
		System.out.println(cnt);
		
		//stream
		cnt =0;
		cnt = names.stream().filter(name -> name.contains("p")).count();
		System.out.println(cnt);
	}

}
