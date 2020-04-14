package com.ssafy.step01.recursive;

public class R02_FiboTest {
	
	private static long fibo(int n) {
		if(n<=1) return n;
		return fibo(n-1)+ fibo(n-2);
	}

	public static void main(String[] args) {

	}

}
