package com.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomTest {
	
	public static void main(String[] args) {
		//난수 발생
		/*Random rand = new Random();
		int i = rand.nextInt(45);
		System.out.println(i);*/
		
		//키보드로 인원수를 입력받아 배열 생성하기
		// 각각의 사람별 키를 배열에 입력하기(난수 발생 이용)
		// 배열에 저장된 키 중 제일 큰 값을 알아내 출력하기
		
		Scanner sc = new Scanner(System.in);
		
		int classmate = sc.nextInt();
		
		int[] classroom = new int[classmate];
		Random rand = new Random();
		int tall=0;
		
		for (int i = 0; i < classmate; i++) {
			int height = rand.nextInt(60) + 130;
			classroom[i] = height;
		}
		
		System.out.println("Classmate:" + Arrays.toString(classroom));
		
		for(int i =0;i<classmate;i++) {
			if(classroom[i]> tall)
				tall = classroom[i];
		}
		System.out.println("Tallest:" + tall);
		
		
		
	}
}
