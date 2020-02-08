package algo_basic.day4;

import java.util.Arrays;

public class GreedyTest {
	private static int[] nums = {9,6,7,8,8,7};
	private static int[] counts = new int[10];
	
	private static String[] data = {"667767"};
	
	
	public static void main(String[] args) {
		//babyGinGreed();
		for (String str:data) {
			int[] counts = new int[10];
			for (int c = 0; c < str.length(); c++) {
				int num = str.charAt(c) -'0';
				counts[num]++;
			}
			System.out.println(Arrays.toString(counts));
		}
		
		int cnt =0;
		
		for(int i =0;i<counts.length;i++) {
			if(counts[i]>=3) {
				cnt++;
				counts[i]-=3;
				i--;				// 다시 이 칸에서부터 봐야한다.
			}else if(counts[i]>0 && counts[i+1]>0 &&counts[i+2]>0 ) {
				cnt++;
				counts[i]-=1;
				counts[i+1]-=1;
				counts[i+2]-=1;
				i--;
			}
		}
		if(cnt ==2) {
			System.out.println("babygin 입니다");
		}else {
			System.out.println("babygin이 아닙니다");
		}
		
	}
	
	/*public static void babyGinGreed() {
		for (int i = 0; i < nums.length; i++) {
			counts[nums[i]]++;
		}
		if(same() && stair())			// 조건 더 추가해야함
			System.out.println("It is baby gin!");
		
	}
	public static boolean same() {
		for (int i = 0; i < 10; i++) {
			if(counts[i]>=3) {
				counts[i]-=3;
				return true;
			}
		}
		return false;
	}
	public static boolean stair() {
		for (int i = 0; i < 8; i++) {
			if(counts[i]==1 && counts[i+1]==1 && counts[i+2]==1) {
				counts[i]-=1;
				counts[i+1]-=1;
				counts[i+2]-=1;		
				return true;
			}
		}
		return false;
	}*/
	
	
	
	
}
