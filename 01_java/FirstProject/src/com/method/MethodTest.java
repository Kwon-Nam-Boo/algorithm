package com.method;

import java.util.Arrays;

public class MethodTest {
	
	/*static void test1(int a , double b) {}		// 메소드 오버로딩
	static void test1(double b, int a) {}
	
	static void hello(){	// method 정의
		System.out.println("hello");
	}
	static int sum(int a ,int b){
		int result = a + b;
		return result;
	}*/
	
	static int[] arr = {1,2,3,4,5};
	static int[] arr2 = {1,2,3,6,5};
	
	static String getGreeting(String name){
		return name + "be happy!";
	}
	static boolean reverse(boolean change){		// ! 연산자 잘쓰기 ~~
		return !change;
	}
	static String result(boolean a, boolean b){		// 삼항연사자 사용하기
		/*if(a == true && b ==true) return "ok";
		else return "cancel";*/
		return a && b ? "ok" : "cancel";
	}
	static void loopString(int count, String msg){
		for (int i = 0; i < count; i++) {
			System.out.println(msg);
		}
	}
	static double getArea(int r){
		return r*r*3.14;
	}
	static void printCircum(int r){
		System.out.println(2*r*3.14);
	}
	static int[] makeArray(int len){
		int[] make = new int[len];
		return make;
		
	}
	static void total(int[] arr){
		int sum =0;
		for(int i: arr) {
			sum+=arr[i];
		}
		System.out.println(sum);
	}
	static int[]  swap(int[] arr, int a, int b){
		int tmp;
		tmp =arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
		return arr;
	}
	static int findMax(int[] arr){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Integer.max(max, arr[i]);
		}
		return max;
	}
	static int[] reverseArray(int[] arr) {
		int arr2[] = new int[arr.length];
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		int j =0;
		for (int i = arr.length-1 ; i >=0; i--) {
			arr[i] = arr2[j];
			j++;
		}
		return arr;
	}
	
	static void isExist(int[] arr, int key) {
		int i = 0;
		while(i<arr.length && arr[i]!=key) {
			i++;
		}
		if(i< arr.length) System.out.println("exist");
		else System.out.println("not exist");
	}
	
	static boolean equals(int[] arr, int[] arr2) {
		if(arr.length != arr2.length) return false;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=arr2[i]) return false;	
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hello();
		//System.out.println(sum(3,8));
		
		System.out.println(getGreeting("Kwon Nam"));
		
		System.out.println(reverse(true));
		
		System.out.println(result(true,true));

		loopString(3,"i am IronMan");
		
		System.out.println(getArea(3));
		
		printCircum(3);
		
		System.out.println(Arrays.toString(makeArray(5)));
		
		total(arr);
		
		System.out.println(Arrays.toString(swap(arr, 1,3)));
		
		System.out.println(Arrays.toString(reverseArray(arr)));
		
		isExist(arr, 2);
		
		System.out.println(equals(arr,arr2));
		
	}
	
}
