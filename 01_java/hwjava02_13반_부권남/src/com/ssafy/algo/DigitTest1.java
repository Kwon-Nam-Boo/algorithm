package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[1000];			// 입력값을 담을 배열
		int[] answer = new int[10];			// 자리수의 개수를 담을 배열
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		
		while(true) {				
			int find = sc.nextInt();	// 수의 입력
			if(find == 0) {				// 0이면 break
				break;
			}else {
				nums[i] = find;			// 0이 아니면 nums 배열에 저장
				i++;
			}
				
		}
		
		for (int j = 0; j < i; j++) {		// 해당 십의 자리수의 배열을 카운트
			answer[nums[j]/10]+=1;
		}
		
		for (int j = 0; j < answer.length; j++) {		//출력
			if(answer[j]>0) {
				System.out.printf("%d: %d개",j,answer[j]);
				System.out.println();
			}
		}
		
	}

}
