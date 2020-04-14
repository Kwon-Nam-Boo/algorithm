package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		// 1. Collection에서 스트림생성(List, set)
		List<String> names = Arrays.asList("kim", "lee","park","pyo");
		Stream<String> st1 = names.stream();
		
		//중간연산:filter() 컬렉션 안의 각 원소에 대해 조건에 맞는 것만 걸러냄
		//st1.filter(x -> x.contains("p")).forEach(x-> System.out.println(x));
		
		/*Stream<String> a = st1.filter(x -> x.contains("p")); // 중간 연산만 한거
		a.forEach(x -> System.out.println(x));*/
		
		//2.배열에서 스트림 생성
		Integer[] arr = {1,2,3,4,5,6,7,8,9};
		Stream<Integer> st2 = Arrays.stream(arr);
		st2.filter((x) -> {if(x  > 5) return true;
			else return false;}).limit(3).forEach(x-> System.out.println(x));
		st2.filter((x) -> x>5).limit(3).forEach(x-> System.out.println(x));
		
		//3. Stream 직접 생성
		Stream<Integer> st3 = Stream.of(1,2,3,4,5,6,7,8);
		Stream<String> st4 = Stream.of("east","west","south","north");
		//Stream<Circle> st5 = Stream.of(new Circle(3));
		st3.filter(x -> x % 2 == 0).forEach(x-> System.out.println(x));
		//st4.filter(x -> x.length() == 0).forEach(x-> System.out.println(x));
		st4.sorted().forEach(x -> System.out.println(x));
	}

}
