package algo_basic.day4;

import java.util.Arrays;

public class PermuatationTest {
	private static char[] src = {'A','B','C','D'};
	private static int[] num = {2,3,7,7,4,7};
	private static String src2 = "667767";
	private static int[] nums = {1,2,3,4};
	public static void main(String[] args) {
		// src의 원소 중 3개를 선택하는 순열을 만들어보자!
		//makePermutaion(3,0,new char[3], new boolean[src.length]);
		//babyGinGame(0,new int[num.length], new boolean[num.length]);
		//nextPermutation(nums);
		
		// 일단 정렬된 상태로 시작한다.
		Arrays.sort(nums);
		do {
			//System.out.println(Arrays.toString(nums));
		}while(nextPermutation());
	}
	
	// int r: 몇개를 선택하나요?
	// int current: 현재 진행되고 있는 depth
	// char[] temp: 선택된 요소들
	// boolean[] visited: 방문 이력
	public static void makePermutaion(int r,int current,char[] temp, boolean[] visited) {
		if(current==r) {
			System.out.println(Arrays.toString(temp));
			return;
		}else {
			for (int i = 0; i < src.length; i++) {
				if(!visited[i]) {
					visited[i] =true;
					temp[current] =src[i];
					makePermutaion(r,current+1,temp, visited);
					visited[i] =false;
				}		
			}
		}
		
	}
	public static void babyGinGame(int current,int[] temp, boolean[] visited) {
		if(current==num.length) {
			if((sameNum(temp,0,temp.length/2) && stairNum(temp,temp.length/2,temp.length))|| (sameNum(temp,temp.length/2,temp.length) && stairNum(temp,0,temp.length/2))) {
				System.out.println(Arrays.toString(temp));
				System.out.println();
				System.exit(0);
			}else {
				return;
			}
		}else {
			for (int i = 0; i < num.length; i++) {
				if(!visited[i]) {
					visited[i] =true;
					temp[current] =num[i];
					babyGinGame(current+1,temp, visited);
					visited[i] =false;
				}		
			}
			
		}
		
	}
	
	public static boolean sameNum(int[] arr,int start, int end) {
		for (int i = start; i < end-1; i++) {
			if(!(arr[i] == arr[i+1])) return false;
		}
		return true;
	}
	public static boolean stairNum(int[] arr,int start, int end) {
		for (int i = start; i < end-1; i++) {
			if(!(arr[i]+1 == arr[i+1])) return false;
		}
		return true;
	}
	
	
	public static void babyGinA(int r, int c,int[] temp, boolean[] visited) {
		if(c==r) {
			System.out.println(Arrays.toString(temp));
			return;
		}else {
			for (int i = 0; i < 6; i++) {
				if(!visited[i]) {
					visited[i] =true;
					temp[c] =src2.charAt(i);
					babyGinA(r,c+1,temp, visited);
					visited[i] =false;
				}		
			}
		}
		
	}
	
	public static boolean nextPermutation() {
		// step1
		int i;	
		for (i = nums.length-2; i >=0; i--) {
			if(nums[i]<nums[i+1]) {
				break;
			}
		}
		System.out.println(Arrays.toString(nums));
		
		if(i<0) {
			return false;
		}
		// step2
		int j;
		for(j=nums.length-1;j>=0;j--) {
			if(nums[i] <nums[j]) break;
		}
		//System.out.println(j);
		
		//step3: swap
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
		//System.out.println(Arrays.toString(nums));
		
		// step4
		for (int a =i+1,b=nums.length-1; a < b ; a++, b--){
			tmp = nums[a];
			nums[a] = nums[b];
			nums[b] = tmp;
		}
		//System.out.println(Arrays.toString(nums));
		return true;
	}
	

}
