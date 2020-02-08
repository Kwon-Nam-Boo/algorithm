package algo_basic.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RecursionTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(getMulti(3,5));
		 DecToBin(10);
		 
	}
	public static int getMulti(int n, int m) { // n부터 m까지 곱 재귀
		if(n == m )
			return m;
		return n*getMulti(n+1,m);
	}
	@Test
	public void getMutiTest() {
		//assertEquals(getMulti(3,5),60);
		
	}
	
	public static int getPower(int n, int m) {		// n^m 재귀
		if(m == 0)
			return 1;
		else
			return  n*getPower(n,m-1);
	}
	@Test
	public void getPowerTest() {
		//System.out.println(getPower(2,4));
		//assertEquals(getPower(3,5),243);
	}
	
	public static void getDigitSum(int num, int sum) {	// 각 자릿 수 더하기 재귀
		if(num >=0 && num<=9) {
			System.out.println(sum+num);
			return;
		}
		getDigitSum(num /10 , num%10 + sum);
	}
	@Test
	public void getDigitSumTest() {
		//getDigitSum(12321,0);
	
	}
	
	public static int strLen(String str) {		// 문자열 길이 측정을 재귀로
		if(str.equals("")) {
			return 0;
		}
		return 1 + strLen(str.substring(1));
	}
	@Test
	public void strLenTest() {
		//System.out.println(strLen("Hello"));
	
	}
	
	public static void strPri(String str) {		// 문자열 출력을 재귀로
		if(str.equals("")) {
			return;
		}
		System.out.print(str.charAt(0));
		strPri(str.substring(1));
	}
	@Test
	public void strPriTest() {
		 //strPri("Hello world!");
	}
	
	public static void strPriRev(String str) {		// 문자열 역순으로 출력을 재귀로
		if(str.equals("")) {
			return;
		}
		strPriRev(str.substring(1));
		System.out.print(str.charAt(0));			// 재귀 함수 사이로 출력 순서만 바꿈
	}
	@Test
	public void strPriRevTest() {
		// strPriRev("Hello world!");
	}
	
	public static void DecToBin(int n) {			//10진수를 2진수로 재귀
		if(n == 1) {
			System.out.print(n);
			return;
		}
		DecToBin(n/2);
		System.out.print(n%2);
		
	}
	
	@Test
	public void DecToBinTest() {				
		 DecToBin(10);
	}
	
	public static int plusArr(int from, int[] arr) {						// 배열 합 재귀
		if(from ==arr.length)
			return 0;
		
		return arr[from] + plusArr(from+1, arr);
	}
	
	@Test
	public void plusArrTest() {										
		assertEquals(plusArr(0,new int[] {1,2,3}),6);
	}
	
	public static int plusArrMax(int[] arr,int from) {					// 최대 크기 배열 찾기 재귀
		if(from ==arr.length-1)
			return arr[from];
		
		return Math.max(arr[from],plusArrMax(arr,from+1));
	}
	
	@Test
	public void plusArrMaxTest() {
		assertEquals(plusArrMax(new int[] {1,2,3},0),3);
	}
	
	public static int binarySerach(int[] arr,int key ,int start, int end) {		//이진 탐색 재귀
		if(start > end ) {
			return -1;
		}else {
			int middle =(start + end) / 2;
			if(key ==arr[middle])
				return  middle;
			else if(key < arr[middle])
				return binarySerach(arr,key,start, middle -1);
			else
				return binarySerach(arr,key,middle +1,end);
		}
	
	}

	@Test
	public void binarySerachTest() {
		System.out.println(binarySerach(new int[] {0,1,2,5,6,8,9},2,0,5));
	}
	
	public static Boolean Palindrome(String str,int start, int end) {		//양쪽이 같은지 확인 재귀
		if(start ==end)	// 홀수인 경우
			return true;
		else if(start +1 == end) {	//짝수인 경우
			return str.charAt(start) == str.charAt(end);
		}else {
			return str.charAt(start) == str.charAt(end) && Palindrome(str, start+1, end-1);
		}
	}
	
}
