package com.ssafy.java;

import java.util.Random;

public class Lotto {
	
	public void selectLotto() {					// 로또 번호 찾기
		int[] LottoNumber = new int[6];			// 로또 번호 배열
		boolean[] LottoCheck = new boolean[45];	// 겹치는 지 체크하기 위한 불리언
		
		for (int i = 0; i < 6; i++) {
			int number = uniqueNumber();
			
			while(LottoCheck[number] == true) {		// 만약 이미 중복된 숫자라면
				number = uniqueNumber();			// uniqueNumber 반복
			}
			LottoCheck[number] = true;				// true 설정 후 번호 저장
			LottoNumber[i] = number+1; 
			
		}
		for(int value:LottoNumber)
			System.out.print(value + " ");
		
	}
	
	private int uniqueNumber() {					// 0 ~ 44 번호 뽑기 (나중에 1더할것)
		Random rand = new Random();
		int num= rand.nextInt(45);
		return num;
	}
	
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.selectLotto();
		
	}
	
	
}
